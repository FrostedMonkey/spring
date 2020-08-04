package com.cc.config;

import com.cc.bean.Color;
import com.cc.bean.ColorFactory;
import com.cc.bean.Person;
import com.cc.bean.Red;
import com.cc.condition.LinuxCondition;
import com.cc.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @ClassName MainConfig2
 * @Author chenchen
 * @Date 2019/9/9 21:26
 * @Version 1.0
 **/
@Configuration
/**
 * 使用@Import快速导入组件，id默认是组件的全类名
 *
 */
@Import({Color.class, Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
    /**
     * bean在ioc容器中默认是单实例的可以通过@Scope来调整作用域
     * @return
     */
    @Scope("singleton")
    /**
     *   ConfigurableBeanFactory#SCOPE_PROTOTYPE    prototype
     * 	 ConfigurableBeanFactory#SCOPE_SINGLETON     singleton
     * 	 org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST     request
     * 	 org.springframework.web.context.WebApplicationContext#SCOPE_SESSION     session
     *
     * 	 prototype 多实例的 ioc容器启动不会调用方法创建对象放在容器中，而是每次获取时才会调用方法创建对象
     * 	 singleton 单实例的（默认）ioc容器启动会调用方法创建对象放到ioc容器中。以后每次获取就是直接从容器中拿
     * 	 request 同一次请求创建一个实例
     * 	 session 同一个session创建一个实例
     *
     * 	 懒加载
     * 	    单实例bean：默认在容器启动的时候创建对象
     * 	    懒加载：容器启动不创建对象。第一次使用（获取）bean创建对象，并初始化
     */
    @Lazy
    @Bean("Person")
    public Person person(){
        System.out.println("想容器中添加person");
        return new Person("zhangsan",70,"lisi");
    }


    /**
     *  @Conditional({Condition}) 按照一定的条件进行判断，满足条件给容器注册bean(可以用在类上，也可以用在方法上)
     *  如果是windows注册cc
     *  如果是linux注册ht
     *  可以放在属性和方法上
     */
    @Conditional({WindowsCondition.class})
    @Bean("cc")
    public Person person01(){
        return new Person("cc",22,"lis");
    }
    @Conditional({LinuxCondition.class})
    @Bean("ht")
    public Person person02(){
        return new Person("ht",22,"lisi ");
    }

    /**
     * 给容器中注册组件：
     *  1、包扫描+组件标注注解（@Controller、@Service、@Repository、@Component）【自己写的类】
     *  2、@Bean【导入的第三方包里面的组件】
     *  3、@Import【快速给容器中倒入一个组件】
     *      1、@Import（要导入到容器中的组件）：容器中就会自动注册这个组件，id默认为全类名
     *      2、ImportSelector：返回需要导入的组件的全类名数组 需要手写类实现ImportSelector接口
     *      3、ImportBeanDefinitionRegistrar 手动注册bean 需要手写类实现ImportBeanDefinitionRegistrar接口
     *  4、使用spring提供的FactoryBean（工厂bean）
     *      1、默认获取到的是工厂bean调用getObject创建的对象
     *      2、要获取gongchangbean本身需要在id前加&
     */
      @Bean
      public ColorFactory colorFactory(){
          return new ColorFactory();
      }
}
