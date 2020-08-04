package demo15.fourth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName DevBeanConfig
 * @date : 2020-07-20 11:25
 * @Description TODO 开发环境
 **/
@Configuration
@EnvConditional(EnvConditional.Env.DEV) //@1
public class DevBeanConfig {
    @Bean
    public String name() {
        return "我是开发环境!";
    }
}
