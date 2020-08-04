package demo15.third;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : chenchen
 * @ClassName MainConfig
 * @date : 2020-07-20 11:13
 * @Description TODO 总配置类
 **/
@Configuration
@Import({BeanConfig1.class,BeanConfig2.class})//通过@Import将其他2个配置类导入
public class MainConfig {
}
