package com.bm.oms.dao;

import com.bm.oms.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查找用户
     *
     * @param loginName 登录名
     * @param password  密码（为了不增加复杂度，这里不进行加密，使用明文）
     */
    Integer countUserByNameAndPwd(@Param("loginName") String loginName,
                                  @Param("password") String password);

    /**
     * 根据loginName获取用户
     *
     * @param loginName 登录名
     */
    User getByLoginName(@Param("loginName") String loginName);

    /**
     * 分页获取用户列表
     */
    List<User> getAll(
            @Param("start") int start,
            @Param("end") int end,
            @Param("loginName") String loginName,
            @Param("realName") String realName,
            @Param("isForbidden") String isForbidden);

    /**
     * 获取用户列表大小
     */
    int countGetAll(@Param("loginName") String loginName,
                    @Param("realName") String realName,
                    @Param("isForbidden") String isForbidden);
}
