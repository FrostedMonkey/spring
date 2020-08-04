package demo15.seventh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName BeanConfig2
 * @date : 2020-07-20 12:15
 * @Description TODO
 **/
@Configuration
@Conditional(MyConfigurationCondition1.class)
public class BeanConfig2 {
    @Bean
    public String name() {
        return "路人甲Java";
    }
}
