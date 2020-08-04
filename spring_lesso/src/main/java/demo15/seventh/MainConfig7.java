package demo15.seventh;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : chenchen
 * @ClassName MainConfig7
 * @date : 2020-07-20 12:16
 * @Description TODO
 **/
@Configuration
@Import({BeanConfig1.class, BeanConfig2.class})
public class MainConfig7 {
}