package demo15.second;

import demo15.first.MyCondition1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName MainConfig
 * @date : 2020-07-20 10:55
 * @Description TODO
 **/
@Configuration
public class MainConfig {
    @Conditional(MyCondition1.class)
    @Bean
    public String name() {
        return "路人甲Java";
    }

    @Bean
    public String address() {
        return "上海市";
    }
}
