package com.cc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName Cat
 * @Author chenchen
 * @Date 2019/9/11 20:43
 * @Version 1.0
 **/
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat 创建");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat init");
    }
}
