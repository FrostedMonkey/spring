package com.cc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName MYBeanPostProcessor
 * @Author chenchen
 * @Date 2019/9/11 21:29
 * @Version 1.0
 * 初始化前后进行处理
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     *
     * @param bean 容器创建的bean实例
     * @param beanName bean的名称
     * @return 可以直接返回bean，也可以进行包装后返回
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之前--------postProcessBeforeInitialization..."+beanName+"=>"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之后--------postProcessAfterInitialization..."+beanName+"=>"+bean);
        return bean;
    }
}
