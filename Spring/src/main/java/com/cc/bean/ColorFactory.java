package com.cc.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建Spring定义的FactoryBean
 * @ClassName ColorFactory
 * @Author chenchen
 * @Date 2019/9/10 22:46
 * @Version 1.0
 **/
public class ColorFactory implements FactoryBean<Color> {
    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("colorFactoryBean.....");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 控制是否单例 true：单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
