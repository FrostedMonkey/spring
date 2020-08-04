package com.cc.test;

import com.cc.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName IOCTest_LifeCycle
 * @Author chenchen
 * @Date 2019/9/11 20:33
 * @Version 1.0
 **/

public class IOCTest_LifeCycle {

    @Test
    public void test1(){
        //创建ioc容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        //annotationConfigApplicationContext.getBean("car");
        annotationConfigApplicationContext.close();
    }
}
