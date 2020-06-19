package com.imooc.springcloud.service;

import com.imooc.springcloud.bean.Principal;

/**
 * 被代理类和代理都要实现这个接口
 *
 * @version 1.0
 * @date 2020/6/10 13:43
 */

public interface UserService {
    void saveUserBO(String userName);

    Principal getUserName(String userName);
}