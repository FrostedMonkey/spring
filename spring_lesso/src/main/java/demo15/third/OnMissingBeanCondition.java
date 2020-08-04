package demo15.third;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author : chenchen
 * @ClassName OmMissingBeanCondition
 * @date : 2020-07-20 11:08
 * @Description 条件判断类
 **/
public class OnMissingBeanCondition implements Condition {
    /*
     * @author chenchen
     * @data 2020/7/20
     * @return 
     * @description 看容器中是否存在IService类型的bean，不存在的时候返回true
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取bean工厂
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //从容器中获取IService类型bean
        Map<String, IService> serviceMap = beanFactory.getBeansOfType(IService.class);
        //判断serviceMap是否为空
        return serviceMap.isEmpty();
    }
}
