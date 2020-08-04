package com.cc.test;

import com.cc.aop.MathCalculator;
import com.cc.config.MainConfigAOP;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AOP_Test
 * @Author chenchen
 * @Date 2020/2/9 22:38
 * @Version 1.0
 **/
public class AOP_Test {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigAOP.class);

        //1、不要自己创建对象，使用ioc容器中的对象
        MathCalculator mathCalculator = annotationConfigApplicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,0);
        //2、
        annotationConfigApplicationContext.close();
    }
}
