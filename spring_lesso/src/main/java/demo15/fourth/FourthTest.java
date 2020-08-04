package demo15.fourth;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenchen
 * @ClassName FourthTest
 * @date : 2020-07-20 11:27
 * @Description TODO
 **/
public class FourthTest {
    @Test
    public void test2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println(context.getBean("name"));
    }
}
