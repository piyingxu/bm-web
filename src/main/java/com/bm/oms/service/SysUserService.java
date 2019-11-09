package com.bm.oms.service;

import com.bm.oms.dto.res.SysUserResponse;
import com.bm.oms.model.User;

public interface SysUserService {

    /**
     * 验证用户
     *
     * @param loginName 登录名
     * @param password  密码（为了不增加复杂度，这里不进行加密，使用明文）
     */
    Boolean validateUser(String loginName, String password);

    /**
     * 根据登录名获取用户
     *
     * @param loginName 登录名
     */
    User getByLoginName(String loginName);

    /**
     * 根据id获取记录
     *
     * @param id 主键
     */
    SysUserResponse getById(String id);

}
