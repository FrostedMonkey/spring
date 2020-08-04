package demo15.sixth;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : chenchen
 * @ClassName Condition2
 * @date : 2020-07-20 12:10
 * @Description TODO
 **/
public class Condition2 implements Condition, Ordered {//Condition2通过实现了Ordered接口来指定顺序
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(this.getClass().getName());
        return true;
    }

    @Override
    public int getOrder() { //@3getOrder方法返回1
        return 0;
    }
}
