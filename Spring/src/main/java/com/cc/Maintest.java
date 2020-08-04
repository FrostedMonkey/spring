package com.cc;

import com.cc.bean.Person;
import com.cc.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Maintest
 * @Author chenchen
 * @Date 2019/9/8 22:22
 * @Version 1.0
 **/
public class Maintest {
    public static void main(String[] args) {
       /* ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person=applicationContext.getBean(Person.class);
        System.out.println(person);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s:beanNamesForType) {
            System.out.println(s);
        }
    }
}
