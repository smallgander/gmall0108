package com.atguigu.gmall.user.controller;



import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    /**
     * 注解使用dubbo的方式进行注入
     */
    @Reference
    private UserService userService;


    @RequestMapping("userList")
    @ResponseBody
    public List<UserInfo> userList(){
        List<UserInfo> userList = userService.getAll();
        return userList ;
    }
}
