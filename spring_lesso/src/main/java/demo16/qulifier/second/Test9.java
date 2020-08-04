package demo16.qulifier.second;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenchen
 * @ClassName Test9
 * @date : 2020-07-20 15:55
 * @Description TODO
 **/
public class Test9 {
    @Test
    public void test9() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig9.class);
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s", beanName, context.getBean(beanName)));
        }
    }
}
