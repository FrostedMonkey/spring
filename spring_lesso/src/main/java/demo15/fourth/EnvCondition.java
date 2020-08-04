package demo15.fourth;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : chenchen
 * @ClassName EnvCondition
 * @date : 2020-07-20 11:26
 * @Description TODO
 *  * 条件类会解析配置类上面@EnvConditional注解，得到环境信息。
 *  * 然后和目前的环境对比，决定返回true还是false
 **/
public class EnvCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //当前需要使用的环境
        EnvConditional.Env curEnv = EnvConditional.Env.PROD; //@1这个用来指定当前使用的环境，此处假定当前使用的是开发环境，这个我们以后可以任意发挥，比如将这些放到配置文件中
        //获取使用条件的类上的EnvCondition注解中对应的环境
        EnvConditional.Env env = (EnvConditional.Env) metadata.getAllAnnotationAttributes(EnvConditional.class.getName()).get("value").get(0);
        return env.equals(curEnv);
    }

}