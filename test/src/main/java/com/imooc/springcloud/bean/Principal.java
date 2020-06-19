package com.imooc.springcloud.bean;

import com.bocommlife.mi.store.impl.ExpirableGoods;
import lombok.Data;

//继承ExpirableGoods这个类（有设置过期时间和过期开启等方法）
@Data
public class Principal extends ExpirableGoods {

    private long codeGeneratortime; //申请accesscode的时间，用于做单端校验的

    private String userId;  //iop平台集成时的全局用户ID，类型为DGID： UID_***

    private String username; //用户名
}
