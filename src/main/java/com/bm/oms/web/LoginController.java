package com.bm.oms.web;

import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.res.LoginResponse;
import com.bm.oms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/api/oms")
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class LoginController {


    @Autowired
    private LoginService loginService;

    /**
     * 登录请求
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RespResult<LoginResponse> login(String name, String pwd, String code) {
        return loginService.login(name, pwd, code);
    }

    /**
     * 登出
     * */
    @RequestMapping(value = "/logout.do", method = RequestMethod.POST)
    @ResponseBody
    public RespResult<String> logout(){
        return loginService.logout();
    }


}
