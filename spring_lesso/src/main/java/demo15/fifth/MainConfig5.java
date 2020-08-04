package demo15.fifth;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName MainConfig5
 * @date : 2020-07-20 12:05
 * @Description TODO
 **/
@Configuration
@Conditional({Condition1.class, Condition2.class, Condition3.class})
public class MainConfig5 {
}
