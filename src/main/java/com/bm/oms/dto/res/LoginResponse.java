package com.bm.oms.dto.res;

import com.bm.oms.dto.base.BaseEntity;

public class LoginResponse extends BaseEntity {

    private String userId;

    private String loginName;

    private String webContext;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getWebContext() {
        return webContext;
    }

    public void setWebContext(String webContext) {
        this.webContext = webContext;
    }
}
