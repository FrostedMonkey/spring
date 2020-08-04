package com.cc.test;

import com.cc.bean.Boss;
import com.cc.config.MainconfigOfProfile;
import com.cc.config.MyConfigOfAutowried;
import com.cc.dao.BookDao;
import com.cc.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @ClassName IOC_test_profile
 * @Author chenchen
 * @Date 2019/11/7 22:51
 * @Version 1.0
 **/
public class IOC_test_profile {
    //创建ioc容器

    //1、使用命令行动态参数:在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境
    @Test
    public void test1(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //1、创建ioc容器

        //2、设置需要激活的环境
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test","dev");
        //3、注册配置类
        annotationConfigApplicationContext.register(MainconfigOfProfile.class);
        //4、启动容器刷新
        annotationConfigApplicationContext.refresh();

        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
        for (String x:beanNamesForType
             ) {
            System.out.println(x);
        }
    }
}
