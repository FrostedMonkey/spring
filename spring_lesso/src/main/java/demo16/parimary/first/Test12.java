package demo16.parimary.first;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenchen
 * @ClassName Test12
 * @date : 2020-07-20 16:02
 * @Description TODO
 **/
public class Test12 {
    @Test
    public void test12() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig12.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
}
