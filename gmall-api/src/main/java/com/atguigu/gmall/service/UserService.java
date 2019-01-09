package com.atguigu.gmall.service;


import com.atguigu.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有的用户信息
     * @return
     */
    public List<UserInfo> getAll();
    /**
     * 向数据库的添加数据
     */
    public void addUser(UserInfo user);
    /**
     * 修改指id的用户
     */
    public void updateUser(UserInfo user);

    /**
     * 删除用户信息
     */
    public void deleteUser(String id);
    /**
     * 通过指定的id来查询用户信息
     */
    public UserInfo getUser(String id);
}
