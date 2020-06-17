package com.imooc.springcloud.controller;

import com.imooc.springcloud.bean.Principal;
import com.imooc.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luotao
 * @version 1.0
 * @date 2020/6/11 10:57
 */
@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUserName", method = {RequestMethod.POST, RequestMethod.GET})
    public void saveUserName(@RequestParam("userName") String userName) {
        userService.saveUserBO(userName);
    }

    @RequestMapping(value = "/getUserName", method = {RequestMethod.POST, RequestMethod.GET})
    public Principal getUserName(@RequestParam("userName") String userName) {
        return userService.getUserName(userName);
    }
}
