package com.cc.config;

import com.cc.bean.Pink;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportBeanDefinitionRegistrar
 * @Author chenchen
 * @Date 2019/9/10 22:32
 * @Version 1.0
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类
     *                 把所有需要添加到容器中的bean；调用
     *                 registry.registerBeanDefinition()手动注册
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.cc.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.cc.bean.Blue");
        if(red&&blue){
            //指定Bean定义信息（Bean的类型等）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Pink.class);
            //注册一个bean，指定bean名
            registry.registerBeanDefinition("pink",rootBeanDefinition);
        }

    }
}
