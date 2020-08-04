package demo15.sixth;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenchen
 * @ClassName SixthTest
 * @date : 2020-07-20 12:12
 * @Description TODO
 **/
public class SixthTest {
    @Test
    public void test6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig6.class);
    }
    /**
     * com.javacode2018.lesson001.demo25.test6.Condition3
     * com.javacode2018.lesson001.demo25.test6.Condition2
     * com.javacode2018.lesson001.demo25.test6.Condition1
     */
}
