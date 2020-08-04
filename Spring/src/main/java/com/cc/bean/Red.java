package com.cc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @ClassName Red
 * @Author chenchen
 * @Date 2019/9/10 21:24
 * @Version 1.0
 **/
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc："+applicationContext);
        this.applicationContext=applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名称:"+name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {


        String s = resolver.resolveStringValue("你好${os.name} 我是#{20*18}");
        System.out.println("解析站位符:"+s);
    }
}
