package com.cc.config;

/**
 * @ClassName MainConfigOfLifeCycle
 * @Author chenchen
 * @Date 2019/9/11 20:26
 * @Version 1.0
 **/

import com.cc.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * bean的生命周期：
 *      bean创建---初始化---销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法。
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 * 初始化：
 *      在对象创建完成，并赋值好，调用初始化方法。
 * 销毁：
 *      单实例：在容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法。
 *
 *

 *
 *
 * 1、指定初始化、销毁方法；
 *      1、以前基于xml配置，我们有init-method 和 destroy-method方法这些方法必须没有参数但可以抛出任何异常；现在我们可以通过@Bean(initMethod = "init",destroyMethod = "detory")
 * 2、让bean实现InitializingBean（定义初始化逻辑）
 *          实现DisposableBean（定义销毁逻辑）这两个接口是Spring提供
 * 3、使用JSR250
 *      @PostConstruct:在bean创建完成并且属性赋值完成，来执行初始化方法
 *      @PreDestory:在容器销毁bean之前，通知我们进行销毁方法
 * 4、BeanPostProcessor：bean的后置处理器
 *      在bean初始化前后进行一些处理工作
 *      postProcessBeforeInitialization：在初始化之前工作
 *      postProcessAfterInitialization：在初始化之后工作
 *
 * BeanPostProcessor原理
 * 遍历得到容器中所有的BeanPostProcessor；挨个执行BeforeInitialization，一旦返回null，跳出for循环，不会执行后面的BeanPostProcessor
 * populateBean(beanName, mbd, instanceWrapper)给bean进行属性赋值
 * initializeBean(beanName, exposedObject, mbd);初始化bean
 * {
 * applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 * invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化方法
 * applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 * 首先会对bean进行属性赋值---》初始化bean---》applyBeanPostProcessorsBeforeInitialization---》invokeInitMethods---》applyBeanPostProcessorsAfterInitialization
 *
 * Spring底层对BeanPostProcessor使用
 *      bean赋值，注入其他组件@Autowirte，生命周期注解功能，@Async，xxxBEanPostProcessor
 *
 *
 */
@ComponentScan("com.cc.bean")
@Configuration
public class MainConfigOfLifeCycle {
    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "detory")
    public Car car(){
        return new Car();
    }


}
