package demo16.parimary.second;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenchen
 * @ClassName Test13
 * @date : 2020-07-20 16:06
 * @Description TODO
 **/
public class Test13 {
    @Test
    public void test13() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig13.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
}
