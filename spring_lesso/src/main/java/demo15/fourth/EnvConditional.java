package demo15.fourth;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : chenchen
 * @ClassName EnvConditional
 * @date : 2020-07-20 11:22
 * @Description TODO 自定义注解

 **/
@Conditional(EnvCondition.class) //@1这个注解上面使用到了@Conditional注解，这个地方使用到了一个自定义Conditione类：EnvCondition
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnvConditional {
    //环境(测试环境、开发环境、生产环境)
    enum Env { //@2枚举，表示环境，定义了3个环境
        TEST, DEV, PROD
    }

    //环境
    Env value() default Env.DEV; //@3这个参数用指定环境上面这个注解一会我们会用在不同环境的配置类上面
}