package com.bm.oms.service;

import com.bm.oms.dto.base.RespResult;
import com.bm.oms.dto.res.LoginResponse;

public interface LoginService {

    RespResult<LoginResponse> login(String loginName, String pwd, String code);

    RespResult<String> logout();

}
