package com.cc.config;

/**
 * @ClassName MyConfigOfAutowried
 * @Author chenchen
 * @Date 2019/9/18 23:03
 * @Version 1.0
 **/

import com.cc.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 * 1、@Autowrite:自动注入
 *      1、默认优先按照类型去容器中找到对应的组件annotationConfigApplicationContext.getBean(BookDao.class)找到就赋值
 *      2、如果找到多个相同的组件，在将属性的名称作为组件的id去容器中查找
 *              applicatioContext.getBean("bookDao")
 *      3、@Qualifier("bookDao")使用@Qualifier指定需要装配的组件的id而不是使用属性名
 *      4、自动装配默认一定要将属性赋值好，没有就会报错
 *          可以使用@Autowired(required = false)
 *      5、@Primary：让Spring进行自动装配的时候默认使用首选的bena
 *          也可以继续使用@Qualifier指定需要装配的bean的名字(@Qualifier的优先级要高于@Primary)
 *      BookService{
 *          @Autowrite
 *          BookDao bookDao；
 *
 *      }
 *  2、Spring还支持试用@Resouurce(JSR250)和Inject（JSR330）【java规范的注解】
 *     @Resource:
 *              可以和@Autowirted一样实现自动装配功能；默认是按照组件名称进行装配的
 *              没有能支持@Primary功能没有支持@Autowrited（reqiured=false）
 *      @Inject:
 *          需要导入javax.inject包 和Autowrited的功能一样。没有required=false的功能
 *      @Autowrite是Spring定义的 @Resource和@Inject都是java规范
 * AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能
 *  3、@Autowrited：构造器、属性、方法、参数 都是从容器中获取组件的值
 *      1）、标注在方法上   //标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值 方法使用的参数，自定义类型的值从ioc容器中获取（ @Bean标注的方法创建对象时，方法参数的值从容器中获取）
 *      2）、标注在构造器上 构造器需要的组件，都是从容器中获取（如果组件只有一个有参构造器，这个有参构造器的@Autowrited可以省略，参数位置的组件还是可以从容器中获取）
 *      3）、放在参数位置
 *  4、自定义组件想使用Spring容器底层的一些组件：ApplicationContext，BeanFactory
 *      自定义组件实现xxxAware 在创建对象的时候，会调用接口规定的方法注入相关组件
 *      把Spring底层一些组件注入到自定义的Bean中
 *      xxxAware:使用xxxProcessor
 *
 *
 */

@Configuration
@ComponentScan({"com.cc.controller","com.cc.service","com.cc.dao","com.cc.bean"})
public class MyConfigOfAutowried {

    @Primary
    @Bean(value = "bookDao")
    @Resource
    public BookDao bookDao(){
        BookDao bookDao2=new BookDao();
        bookDao2.setLabel("2");
        return bookDao2;
    }
}
