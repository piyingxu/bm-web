package com.bm.oms.service.impl;

import com.bm.oms.dao.UserMapper;
import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.base.RespUtil;
import com.bm.oms.dto.base.ServiceException;
import com.bm.oms.dto.res.LoginResponse;
import com.bm.oms.enums.RespOmsCode;
import com.bm.oms.model.User;
import com.bm.oms.service.LoginService;
import com.bm.oms.service.SysUserService;
import com.bm.oms.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private SysUserService sysUserService;

    public RespResult<LoginResponse> login(String loginName, String pwd, String code, HttpServletRequest request) {
        LoginResponse loginResponse = new LoginResponse();
        System.out.println(request.getSession().getId());
        //验证验证码
        /*Object vcode = request.getSession().getAttribute("vcode");
        if (vcode == null || code.equalsIgnoreCase(vcode.toString())) {
            throw new ServiceException(RespOmsCode.VCODE_ERROR);
        }*/
        //当前用户
        boolean validRlt = sysUserService.validateUser(loginName, pwd);
        if (!validRlt) {
            throw new ServiceException(RespOmsCode.USERPWD_ERROR);
        }

        //还可以把用户信息放入session中
        request.getSession().setAttribute("sysUser", loginName);

        //拼接返回信息
        User userTest = sysUserService.getByLoginName(loginName);
        loginResponse.setUserId(userTest.getId());
        loginResponse.setLoginName(loginName);
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        loginResponse.setWebContext(baseUrl);
        return RespUtil.success(loginResponse);
    }

    /**
     * 登出并清理session
     */
    public RespResult<String> logout() {
        SecurityUtils.getSubject().logout();//登出
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().removeAttribute("sysUser");//清理session
        return null;
    }
}
