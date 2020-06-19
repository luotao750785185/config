package com.imooc.springcloud.bean;

import com.bocommlife.mi.store.impl.Store;
import org.springframework.stereotype.Service;

@Service
public class PrincipalStore {

    private final String name = "Principal666";

    private Store store;

    public PrincipalStore(Store store) {
        this.store = store;
    }

    public void savePrincipal(String key, Principal principal) {
        //保存到store 文件夹下name（Principal666）文件夹下
        store.Save(name, key, principal);
    }

    public Principal fetchPrincipal(String accesscode) {
        return store.fetch(name, accesscode, Principal.class);
    }

    public void deletePrincipal(String accesscode) {
        store.delete(name, accesscode);
    }

}
