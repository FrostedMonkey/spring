package demo15.seventh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName BeanConfig1
 * @date : 2020-07-20 12:15
 * @Description TODO 通过配置类注册Service
 **/
@Configuration
public class BeanConfig1 {
    @Bean
    public Service service() {
        return new Service();
    }
}