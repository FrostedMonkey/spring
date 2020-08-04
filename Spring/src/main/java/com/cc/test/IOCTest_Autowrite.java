package com.cc.test;

import com.cc.bean.Boss;
import com.cc.bean.Person;
import com.cc.config.MainConfigOfPropertyValues;
import com.cc.config.MyConfigOfAutowried;
import com.cc.dao.BookDao;
import com.cc.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName IOCTest_Autowrite
 * @Author chenchen
 * @Date 2019/9/18 23:07
 * @Version 1.0
 **/
public class IOCTest_Autowrite {
    //创建ioc容器
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MyConfigOfAutowried.class);
    @Test
    public void test1(){
        BookService bean = (BookService)annotationConfigApplicationContext.getBean(BookService.class);
        System.out.println(bean);
        Boss bean1 = annotationConfigApplicationContext.getBean(Boss.class);
        System.out.println(bean1);
        BookDao b=(BookDao)annotationConfigApplicationContext.getBean(BookDao.class);
        System.out.println(b);
        annotationConfigApplicationContext.close();
    }
}
