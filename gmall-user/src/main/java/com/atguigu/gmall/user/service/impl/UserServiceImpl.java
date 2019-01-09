package com.atguigu.gmall.user.service.impl;



import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<UserInfo> getAll() {
        List<UserInfo> userInfos =  userMapper.selectAll();
        return userInfos;
    }

    /**
     * 添加用户信息
     * @param user
     */
    @Override
    public void addUser(UserInfo user) {
        userMapper.insert(user);
    }

    /**
     * 更新用户信息
     * @param user
     */
    @Override
    public void updateUser(UserInfo user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 删除用户信息
     * @param id
     */
    @Override
    public void deleteUser(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @Override
    public UserInfo getUser(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
