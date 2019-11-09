package com.bm.oms.web;

import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.res.LoginResponse;
import com.bm.oms.service.LoginService;
import com.bm.oms.service.VCodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/api/oms")
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private VCodeService vCodeService;

    /**
     * 登录请求
     */
    @ApiOperation("1、登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RespResult<LoginResponse> login(String name, String pwd, String code) {
        return loginService.login(name, pwd, code);
    }

    /**
     * 登出
     * */
    @ApiOperation("2、退出")
    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public RespResult<String> logout(){
        return loginService.logout();
    }

    /**
     * 获取验证码
     * @param response
     */
    @ApiOperation("3、获取验证码")
    @RequestMapping(value="/getVCode",method= RequestMethod.GET)
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) throws Exception{
        vCodeService.outPutVCode(request,response);
    }


}
