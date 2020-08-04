package com.cc.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName Dog
 * @Author chenchen
 * @Date 2019/9/11 21:24
 * @Version 1.0
 **/
@Component
public class Dog {
    public Dog(){
        System.out.println("dog construct");
    }
    //对象创建并赋值之后创建
    @PostConstruct
    public void init(){
        System.out.println("dog。。。。@PostConstruct");
    }
    @PreDestroy
    public void detory(){
        System.out.println("dog.....@PreDestroy");
    }
}
