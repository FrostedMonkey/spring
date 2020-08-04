package demo15.fourth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName TestBeanConfig
 * @date : 2020-07-20 11:24
 * @Description TODO 测试环境
 **/
@Configuration
@EnvConditional(EnvConditional.Env.TEST)//@1指定的测试环境
public class TestBeanConfig {
    @Bean
    public String name() {
        return "我是测试环境!";
    }
}
