package demo15.fourth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName ProdBeanConfig
 * @date : 2020-07-20 11:25
 * @Description TODO 生产环境
 **/

@Configuration
@EnvConditional(EnvConditional.Env.PROD) //@1
public class ProdBeanConfig {
    @Bean
    public String name() {
        return "我是生产环境!";
    }
}

