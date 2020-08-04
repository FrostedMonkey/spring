package demo15.sixth;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : chenchen
 * @ClassName MainConfig6
 * @date : 2020-07-20 12:12
 * @Description TODO
 **/
@Configuration
@Conditional({Condition1.class, Condition2.class, Condition3.class})//@5
public class MainConfig6 {
}