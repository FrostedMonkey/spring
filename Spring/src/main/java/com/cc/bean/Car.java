package com.cc.bean;

import org.springframework.stereotype.Component;

/**
 * @ClassName Car
 * @Author chenchen
 * @Date 2019/9/11 20:31
 * @Version 1.0
 **/
@Component
public class Car {
    public Car(){
        System.out.println("car 创建");
    }
    public void init(){
        //进行一些初始化赋值
        System.out.println("car init");
    }
    public void detory(){
        System.out.println("car detory");
    }
}
