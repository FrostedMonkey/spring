package demo15.fifth;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenchen
 * @ClassName FifthTest
 * @date : 2020-07-20 12:05
 * @Description TODO
 **/
public class FifthTest {
    @Test
    public void test5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig5.class);
    }
}
