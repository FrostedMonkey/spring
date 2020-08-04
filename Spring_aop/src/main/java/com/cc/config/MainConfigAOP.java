package com.cc.config;

import com.cc.aop.LogAspects;
import com.cc.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName MainConfigAOP
 * @Author chenchen
 * @Date 2020/2/9 20:58
 * @Version 1.0
 **/

/**
 * AOP:【动态代理】
 * 在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式；
 * 1、导入aop模块:Spring AOP(spring-aspects)
 * 2、定义一个业务逻辑类（MathCalculator）；在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束、方法出现异常）
 * 3、定义日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCalculator.div()运行到哪里了
 *      通知方法：
 *          前置通知：(@Before)logStart：在目标方法（div）运行之前运行
 *          后置通知：(@After)logEnd：在目标方法（div）运行结束之后运行（无论方法正常结束还是异常结束都会正常调用）
 *          返回通知：(@AfterReturning)logReturn：在目标方法（div）正常返回之后运行
 *          异常通知：(@AfterThrowing)logException：在目标方法（div）出现异常以后运行
 *          环绕通知：(@Afound)动态代理，手动推进目标方法运行（joinPoint.proced）
 * 4、给切面类的目标方法标注何时何地运行（通知注解）
 * 5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中
 * 6、告诉Spring那个类是切面类（切面类上加注解@Aspect）
 * 7、xml开启基于注解版的切面功能<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 *      在配置类中加@EnableAspectJAutoProxy(开启基于注解的aop模式)
 *
 *
 * 三步：
 * 1、将业务逻辑组件和切面类都加入到容器中；告诉Spring哪个是切面类（@Aspect）
 * 2、在切面类上的每一个通知方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3、开启基于注解的AOP模式
 *
 * AOP原理【给容器中注册了什么组件，这个组件什么时候工作，这个组件工作时候的功能】
 *      @EnableAspectJAutoProxy
 * 1、@EnableAspectJAutoProxy是什么？
 *      @Import(AspectJAutoProxyRegistrar.class)给容器中导入AspectJAutoProxyRegistrar
 *          利用AspectJAutoProxyRegistrar自定义给容器中注册bean(AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);)
 *          如果BeanDefinitionRegistry包含了internalAutoProxyCreator则需要给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 *          internalAutoProxyCreator=AnnotationAwareAspectJAutoProxyCreator
 *
 *      给容器中注册一个AnnotationAwareAspectJAutoProxyCreator
 * 2、给容器中注册一个AnnotationAwareAspectJAutoProxyCreator：
 *      AnnotationAwareAspectJAutoProxyCreator
 *          ->AspectJAwareAdvisorAutoProxyCreator
 *              ->AbstractAdvisorAutoProxyCreator
 *                  ->AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor（后置处理器）, BeanFactoryAware
 *                  后置处理器（在bean初始化完成前后做操作）、自动装配BeanFactory
 *AbstractAutoProxyCreator.setBeanFactory(BeanFactory beanFactory)
 *AbstractAutoProxyCreator.有后置处理器的逻辑
 *
 * AbstractAdvisorAutoProxyCreator.setBeanFactory(BeanFactory beanFactory)--->initBeanFactory();
 * AspectJAwareAdvisorAutoProxyCreator.initBeanFactory();
 *
 *
 * 流程
 *      1）、传入配置类，创建ioc容器
 *      2）、注册配置类，调用refresh（）刷新容器
 *      3）、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来访便拦截bean的创建
 *          1）、先获取ioc容器已经定义了的需要创建对象的所有BeanPostProcessor
 *          2）、给容器中加别的BeanPostProcessor
 *              	// Separate between BeanPostProcessors that implement PriorityOrdered,
 * 		            // Ordered, and the rest.
 *          3）、有限注册实现了PriorityOrdered接口的BeanPostProcessor
 *          4）、再给容器中注册实现了Order接口的BeanPostProcessor
 *          5）、注册没实现优先级接口的BeanPostProcessor
 *          6）、注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
 *              创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】
 *              1）、创建Bean实例
 *              2）、populateBean：给Bean的各种属性赋值
 *              3）、initializeBean：初始化bean
 *                  1）、invokeAwareMethods():处理Aware接口的方法回调
 *                  2）、applyBeanPostProcessorsBeforeInitialization（）：应用后置处理器的PostProcessorsBeforeInitialization
 *                  3）、invokeAwareMethods（）：执行自定义的初始化方法
 *                  4）、applyBeanPostProcessorsBeforeInitialization（）:执行后置管理器的PostProcessorsBeforeInitialization
 *              4）、BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator)创建成功
 *           7）、把BeanPostProcessor注册到BeanFactory中
 *              beanFactory.addBeanPostProcessor(postProcessor)
 * =================以上是创建和注册AnnotationAwareAspectJAutoProxyCreator的过程==================
 *          AnnotationAwareAspectJAutoProxyCreator =》 InstantiationAwareBeanPostProcessor
 *      4）、finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作；创建剩下的单实例bean
 *              1）、便利获取容器中所有的Bean，依次创建对象getBean(beanName)
 *                  getBean()-->doGetBean()-->getSingleton()-->
 *              2)、创建bean
 *                  【AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，InstantiationAwareBeanPostProcessor，会调用postProcessBeforeInstantiation】
 *                  1）、先从换从中获取当前bean，如果能获取到，说明bean之前被创建过，直接使用，否则在创建
 *                      只要创建好的bean都会被缓存起来
 *                  2）、createBean（）：创建Bean；
 *                      AnnotationAwareAspectJAutoProxyCreator会在任何bean创建之前先尝试返回bean的实例
 *                      【BeanPostProcessor是在Bean对象创建完成初始化前后调用的】
 *                      【InstantiationAwareBeanPostProcessor是在创建Bean实例之前先尝试用后置处理器返回对象的】
 *                      1)、resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation
 *                          希望后置处理器在此能返回一个代理对象；如果能返回代理对象就使用，如果不能就继续
 *                          1）、后置处理器先尝试返回对象
 *                              bean=applyBeanPostProcessorsBeforeInstantiation();
 *                                  拿到所有后置处理器,如果是InstantiationAwareBeanPostProcessor;
 *                                  就执行postProcessBeforeInstantiation
 *                              if(bean!=null){
 *                                  bean = applyBeanPostProcessorsAfterInitialization(bean,beanName)
 *                              }
 *                      2）、doCreateBean(beanName,mbdToUse,args);真正的去创建一个bean实例。和3.6流程一样
 * AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】的作用：
 * 1）、每一个bean创建之前，调用postProcessBeforeInstantiation
 *      1）、当前bean是否在advisedBeans中（保存了所有需要增强的bean）
 *      2）、当前bean是否是基础类型的Advice、Pointcut、Advisor、AopInfrastructureBean，或者是否是切面（@Aspect）
 *      3）、是否需要跳过
 *          1）、获取候选的增强器（切面里面的通知方法）【List<Advisor> candidateAdvisors】
 *              每一个封装的通知方法的增强器是InstantiationModelAwarePointcutAdvisor
 *              判断每一个增强器是否是AspectJPointcutAdvisor类型的；返回true
 *          2）、永远返回false
 * 2）、创建对象
 * postProcessBeforeInstantiation；//包装如果需要的情况下
 *      return wrapIfNecessary(bean, beanName, cacheKey);
 *      1）、获取当前bean的所有增强器（通知方法）Object[] specificInterceptors
 *          1、找到候选的所有增强器（找哪些通知方法是需要切入当前bean方法的）
 *          2、获取到能在当前bean使用的增强器。
 *          3、给增强器排序
 *      2）、保存当前bean在advisedBeans中
 *      3）、如果当前bean需要增强，创建当前bean 的代理对象
 *          1）、获取所有增强器（通知方法）
 *          2）、保存到proxyFactory
 *          3）、创建代理对象
 *               JdkDynamicAopProxy(config);
 *               ObjenesisCglibAopProxy(config);
 *      4）、给容器中返回当前组件使用cglib增强了的代理对象
 *      5）、以后容器中获取到的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行通知方法的流程
 *  3）、目标方法的执行
 *      容器中保存了组件的代理对象（cglib增强后的对象），这个对象里面保存了详细信息（增强器，目标对象）
 *      1）、CglibAopProxy.intercept();拦截目标方法的执行
 *      2）、根据ProxyFactory对象获将要执行的目标方法拦截器链
 *          List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
 *          1）、List<Object> interceptorList保存所有拦截器（总共有5个）
 *              一个默认的ExposeInvocationInterceptor和4个增强器
 *          2）、遍历所有的增强器，将其转为Interceptor
 *          registry.getInterceptors(advisor);
 *          3）、将增强器转为List<MethodInterceptor>;
 *          如果是MethodInterceptor，直接加入到集合中
 *          如果不是，使用AdvisorAdapter将增强器转为MethodInterceptor；
 *          转换完成返回MethodInterceptor数组
 *      3）、如果没有拦截器链，直接执行目标方法
 *      拦截器链（每一个通知方法又被包装为方法拦截器，利用MethodInterceptor机制）
 *      4）、如果有拦截器链，把需要执行的目标对象，目标方法，拦截器链等信息传入创建一个CglibMethodInvocation对象，并调用其proceed()方法
 *      5）、拦截器链的触发过程
 *
 *
 *
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
