package com.bm.oms.enums;

import com.bm.oms.dto.base.RespCode;

public enum RespOmsCode implements RespCode {

    VCODE_ERROR("OMS_000000", "验证码错误"),

    USERPWD_ERROR("OMS_000001", "用户名或密码错误"),

    SYSTEM_BUSY("OMS_000002", "系统繁忙"),

    SESSION_OUT("OMS_000003", "请重新登录"),



    MAX("OMS_999999", "Max");

    private String code;
	
    private String msg;

    RespOmsCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
