package com.bm.oms.service;

import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.res.LoginResponse;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    RespResult<LoginResponse> login(String loginName, String pwd, String code, HttpServletRequest request);

    RespResult<String> logout();

}
