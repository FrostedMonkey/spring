package com.cc.test;

import com.cc.bean.Person;
import com.cc.config.MainConfigOfLifeCycle;
import com.cc.config.MainConfigOfPropertyValues;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName IOCTest_PropertyValue
 * @Author chenchen
 * @Date 2019/9/18 22:34
 * @Version 1.0
 **/
public class IOCTest_PropertyValue {
    //创建ioc容器
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
    @Test
    public void test1(){
        printBeans(annotationConfigApplicationContext);
        System.out.println("====================");
        Person p=(Person)annotationConfigApplicationContext.getBean("person");
        System.out.println(p);
        System.out.println("======================");
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("person.EnglistName");
        System.out.println(property);
        annotationConfigApplicationContext.close();
    }
    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String [] names=annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:names
        ) {
            System.out.println(name);
        }
    }
}
