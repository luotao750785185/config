package com.imooc.springcloud.service.impl;

import com.imooc.springcloud.bean.Principal;
import com.imooc.springcloud.repository.UserRepository;
import com.imooc.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luotao
 * @version 1.0
 * @date 2020/6/11 11:04
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUserBO(String userName) {
        userRepository.saveUserBO(userName);
    }

    @Override
    public Principal getUserName(String userName) {
        return userRepository.getUser(userName);
    }
}
