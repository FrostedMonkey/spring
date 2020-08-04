package com.cc.config;

import com.cc.bean.Person;
import com.cc.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类等同于之前的配置文件
 * @ClassName Mainconfig
 * @Author chenchen
 * @Date 2019/9/8 22:26
 * @Version 1.0
 **/

/**
 * 此注解标志这是一个配置类
 */
@Configuration
/**
 * @ComponentScan(value = "com.cc")//
 * 作用等同于配置文件中的context:component-scan并且在jdk1.8中支持多个@ComponentScan（@Repeatable(ComponentScans.class)）
 * 例如：@ComponentScan(value = "com.cc.dao") @ComponentScan(value = "com.cc.bean")这两个和在一起就是扫描dao包下和bean包下
 * 不是jdk1.8也可以使用ComponentScans指定多个规则
 *  ComponentScans(value = {})
 */
@ComponentScan(value = "com.cc.bean",includeFilters = {/*@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = BookService.class),*/
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes = MyTypeFilter.class)})
/**
 * ComponentScan中有 ComponentScan.Filter[] includeFilters() default {};扫描的时候只包含那些组件
 * ComponentScan.Filter[] excludeFilters() default {};扫描的时候按照什么规则排除哪些组件
 * 这两个方法可以指定要扫描或不扫描哪些。但是includeFilters要配合useDefaultFilters;false使用-->相当于配置文件中use-default-filters="false"
 *  使用@Filter指定扫描规则，规则而的方式有;
     *  FilterType.ANNOTATION：按照注解过滤
     *  FilterType.ASSIGNABLE_TYPE：按照给定的类型
     *  FilterType.ASPECTJ：使用ASPECTJ表达式
     *  FilterType.REGEX：正则
     *  FilterType.CUSTOM：自定义规则，创建类实现TypeFilter接口 @ComponentScan.Filter(type=FilterType.CUSTOM,classes = MyTypeFilter.class)}
 * basePackages与value:  用于指定包的路径，进行扫描
 * basePackageClasses: 用于指定某个类的包的路径进行扫描
 */

/**
 * ComponentScans其实和ComponentScan一样，相当于一个ComponentScan数组
 */

public class MainConfig {

    @Bean(value = "person01")//给容器中注册bean 类型就是返回值类型 id默认用方法名作为id（为getPerson），如果指定value，那么id就是value（person01）
    public Person getPerson(){
        return new Person("lisi",20,"lisi");
    }
}
