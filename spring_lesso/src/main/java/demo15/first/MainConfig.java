package demo15.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName MainConfig
 * @date : 2020-07-20 10:42
 * @Description TODO配置类
 **/
//@Conditional(MyCondition1.class) //@1使用了自定义的条件类
@Configuration
public class MainConfig {
    @Bean
    //@2通过@Bean标注name这个方法，如果这个配置类成功解析，
    //会将name方法的返回值作为bean注册到spring容器
    public String name() {
        return "java";
    }
}
