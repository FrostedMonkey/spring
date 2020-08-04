package com.cc.test;

import com.cc.bean.Blue;
import com.cc.bean.Person;
import com.cc.config.MainConfig;
import com.cc.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @ClassName Test
 * @Author chenchen
 * @Date 2019/9/8 22:38
 * @Version 1.0
 **/
public class IocTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
    @SuppressWarnings("resource")
    @Test
    public void testImport(){
        printBeans(annotationConfigApplicationContext);
        Blue bean = annotationConfigApplicationContext.getBean(Blue.class);
        System.out.println(bean);
        //工厂bean获取的是调用getObject创建的对象
        Object colorFactory = annotationConfigApplicationContext.getBean("colorFactory");
        Object colorFactory2 = annotationConfigApplicationContext.getBean("colorFactory");
        System.out.println("bean2"+colorFactory.getClass());
        System.out.println(colorFactory==colorFactory2);

        /**
         * 使用&获取FactoryBean本身
         */
        Object colorFactory3 = annotationConfigApplicationContext.getBean("&colorFactory");
        System.out.println("3"+colorFactory3);
    }
    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext){
        String [] names=annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:names
             ) {
            System.out.println(name);
        }
    }
    @Test
    public void test1(){

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test2(){


        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
      /*  for (String name:beanDefinitionNames) {
            System.out.println(name);
        }*/
        System.out.println("ioc容器创建完成");
       /* Object bean=annotationConfigApplicationContext.getBean("person");
        Object bean2=annotationConfigApplicationContext.getBean("person");
        System.out.println(bean==bean2);*/

    }

    @Test
    public void test3(){

        ConfigurableEnvironment configurableEnvironment=annotationConfigApplicationContext.getEnvironment();
        String property = configurableEnvironment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);

        for (String name:beanNamesForType) {
            System.out.println(name);
        }
        Map<String, Person> beansOfType = annotationConfigApplicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}
