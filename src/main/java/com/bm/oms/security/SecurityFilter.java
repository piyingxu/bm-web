package com.bm.oms.security;

import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.base.RespUtil;
import com.bm.oms.enums.RespOmsCode;
import com.bm.oms.util.GsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = "/api/lobby/*")
public class SecurityFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityFilter.class);

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(
                    "/api/lobby/player/login"
            )));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("security filter init");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        Thread.currentThread().setName(UUID.randomUUID().toString());
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        int contentLength = request.getContentLength();
        if (contentLength > 0) {
            request = new RequestWrapper((HttpServletRequest) req);
        }
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");

        boolean allowedPath = checkPath(path);
        if (allowedPath) {
            chain.doFilter(request, response);
        } else {
            //RespResult<Boolean> securityDto = RespUtil.success(Boolean.TRUE);
            RespResult<Boolean> securityDto = validate(request);
            if (!securityDto.getData()) {
                handleResponse(response, securityDto);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    private Boolean checkPath(String path) {
        if (path != null && path.length() > 2) {
            String[] paths = path.split("/");
            if (paths.length > 0) {
                String versionNum = paths[paths.length - 1];
                Matcher matcher = Pattern.compile("^v\\d+$").matcher(versionNum);
                if (matcher.find()) {
                    String curPath = "";
                    for (int i = 0; i < paths.length - 1; i++) {
                        curPath += paths[i] + "/";
                    }
                    path = curPath;
                }
            }
        }
        return hasPath(path);
    }

    public static Boolean hasPath(String path) {
        if (StringUtils.isNotBlank(path)) {
            return ALLOWED_PATHS.contains(path);
        }
        return false;
    }

    private RespResult<Boolean> validate(HttpServletRequest req) {
        try {
            RespResult<Boolean> securityDto = RespUtil.success(Boolean.TRUE);

            return securityDto;
        } catch (Exception e) {
            LOG.error("security filter validate error, e={}", e);
            return new RespResult<>(RespOmsCode.SYSTEM_BUSY.getCode(), RespOmsCode.SYSTEM_BUSY.getMsg(), Boolean.FALSE);
        }
    }

    private void handleResponse(HttpServletResponse response, RespResult<Boolean> respResult) throws IOException {
        if (RespUtil.isFailed(respResult)) {
            respResult.setData(null);
        }
        String json = GsonUtils.toJson(respResult);
        LOG.info("security filter handleResponse={}", respResult);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getOutputStream().write(json.getBytes("UTF-8"));
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    public String getRemoteAddr(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotEmpty(remoteAddr)) {
            remoteAddr = request.getHeader("X-Forwarded-For");
        } else if (StringUtils.isNotEmpty(remoteAddr)) {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        } else if (StringUtils.isNotEmpty(remoteAddr)) {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    @Override
    public void destroy() {
        LOG.info("security filter destroy");
    }
}
