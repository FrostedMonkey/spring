package com.cc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName Boss
 * @Author chenchen
 * @Date 2019/11/5 22:20
 * @Version 1.0
 **/
//默认加载ioc容器中的组件，容器启动会调用无参构造器创建对象，在进行初始化赋值等操作
@Component
public class Boss {
    private Car car;
    //构造器需要的组件，都是从容器中获取
    //@Autowired
    //放在参数位置
    public Boss(@Autowired Car car){
        this.car=car;
    }

    public Car getCar() {
        return car;
    }
    //@Autowired
    //标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
