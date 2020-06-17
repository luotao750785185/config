package com.imooc.springcloud.repository;

import com.imooc.springcloud.bean.Principal;

/**
 * @author luotao
 * @version 1.0
 * @date 2020/6/15 9:32
 */
public interface UserRepository {
    Principal getUser(String userName);

    void saveUserBO(String userName);
}
