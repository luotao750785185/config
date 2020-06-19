package com.imooc.springcloud.repository;


import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.imooc.springcloud.bean.Principal;
import com.imooc.springcloud.bean.PrincipalStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author luotao
 * @version 1.0
 * @date 2020/6/11 11:05
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private PrincipalStore principalStore;
    //这个注解在实体层无效，获取不到值（加了@component也无效），需要像mapper那样配置扫描路径，如果调用的地方多了，放抽象类里面（抽象类不需要加任何注解）
    @Value("${principal.expiredPeriod}")
    private long expiredPeriod;//对象的过期时间（即存在多久）

    //CacheType.REMOTE设置为刷新行为是全局唯一,不会出现多个服务器同时去刷新一个key。
    @Cached(expire = 3600, cacheType = CacheType.REMOTE)
    @CacheRefresh(refresh = 1800, stopRefreshAfterLastAccess = 3600, timeUnit = TimeUnit.SECONDS)
    @Override
    public Principal getUser(String userName) {
        // 缓存不存在 todo 查询数据库
        System.out.println("缓存不存在，查询数据库");
        return null;
    }


    @Override
    public void saveUserBO(String userName) {
        Principal principal = new Principal();
        principal.setUsername("luoTao");

        //设置accesscode的生成时间（登录时间）
        principal.setCodeGeneratortime(System.currentTimeMillis());
        //设置过期时间（ms）
        principal.setTimeoutInterval(expiredPeriod);
        principalStore.savePrincipal(userName, principal);
    }
}
