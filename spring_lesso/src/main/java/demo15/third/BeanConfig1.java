package demo15.third;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName BeanConfig1
 * @date : 2020-07-20 11:11
 * @Description TODO 负责注册Service1
 **/
@Configuration
public class BeanConfig1 {
    @Conditional(OnMissingBeanCondition.class) //@1方法之前使用了条件判断
    @Bean
    public IService service1() {
        return new Service1();
    }
}
