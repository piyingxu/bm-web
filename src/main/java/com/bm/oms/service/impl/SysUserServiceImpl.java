package com.bm.oms.service.impl;

import com.bm.oms.dao.UserMapper;
import com.bm.oms.dto.res.SysUserResponse;
import com.bm.oms.model.User;
import com.bm.oms.service.SysUserService;
import com.bm.oms.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gameloft9 on 2017/11/28.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserMapper dao;

    /**
     * 验证用户
     *
     * @param loginName 登录名
     * @param password  密码（为了不增加复杂度，这里不进行加密，使用明文）
     */
    public Boolean validateUser(String loginName, String password) {
        int n = 0;
        try {
            n = dao.countUserByNameAndPwd(loginName, MD5.md5(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0 ? true : false;
    }

    /**
     * 根据登录名获取用户
     *
     * @param loginName 登录名
     */
    public User getByLoginName(String loginName) {
        return dao.getByLoginName(loginName);
    }

    /**
     * 根据id获取记录
     *
     * @param id 主键
     */
    public SysUserResponse getById(String id) {
        SysUserResponse userResponse = new SysUserResponse();
        User user = dao.selectByPrimaryKey(id);
        userResponse.setId(user.getId());
        userResponse.setLoginName(user.getLoginName());
        userResponse.setMobile(user.getMobile());
        userResponse.setOrgId(user.getOrgId());
        userResponse.setOrgName(user.getOrgName());
        userResponse.setRealName(user.getRealName());
        return userResponse;
    }


}
