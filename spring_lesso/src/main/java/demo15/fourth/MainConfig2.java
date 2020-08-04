package demo15.fourth;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : chenchen
 * @ClassName MainConfig2
 * @date : 2020-07-20 11:29
 * @Description TODO
 **/

@Configuration
@Import({TestBeanConfig.class, DevBeanConfig.class, ProdBeanConfig.class})
public class MainConfig2 {
}
