package com.cc.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName WindowsCondition
 * @Author chenchen
 * @Date 2019/9/9 23:36
 * @Version 1.0
 * 判断是否为windows
 **/
public class WindowsCondition implements Condition {
    /**
     *
     * @param context p判断条件能使用的上下文（环境）
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否windows系统
        /**
         * 获取ioc使用的beanfactory
         */
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        /**
         * 获取类加载器
         */
        ClassLoader classLoader = context.getClassLoader();
        /**
         * 获取当前环境信息
         */
        Environment environment = context.getEnvironment();
        /**
         * 获取bean定义的注册类
         */
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        if(property.contains("Windows")){
            return true;
        }
        return false;
    }
}
