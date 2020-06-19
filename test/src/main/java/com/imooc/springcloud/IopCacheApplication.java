package com.imooc.springcloud;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mvel2.util.Make;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@EnableCreateCacheAnnotation//激活@CreateCache注解
@EnableMethodCache(basePackages = "com.imooc.springcloud.repository") //激活@Cached注解
public class IopCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(IopCacheApplication.class, args);
    }
}
