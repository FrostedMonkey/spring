package demo15.third;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName BeanConfig2
 * @date : 2020-07-20 11:12
 * @Description TODO 负责注册Service2
 **/
@Configuration
public class BeanConfig2 {
    @Conditional(OnMissingBeanCondition.class)//@1
    @Bean
    public IService service2() {
        return new Service2();
    }
}
