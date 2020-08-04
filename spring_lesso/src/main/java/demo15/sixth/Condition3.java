package demo15.sixth;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : chenchen
 * @ClassName Condition3
 * @date : 2020-07-20 12:11
 * @Description TODO
 **/
public class Condition3 implements Condition, PriorityOrdered { //@4Condition3实现了PriorityOrdered接口，实现这个接口需要重写getOrder方法，返回1000
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(this.getClass().getName());
        return true;
    }

    @Override
    public int getOrder() {
        return 1000;
    }
}
