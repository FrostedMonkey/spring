package demo15.first;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author : chenchen
 * @ClassName ConditionTest
 * @date : 2020-07-20 10:42
 * @Description TODO
 **/
public class ConditionTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfig.class);
        Map<String,String> serviceMap =context.getBeansOfType(String.class);
        serviceMap.forEach((beanName,bean)->{
            System.out.println(String.format("%s->%s", beanName, bean));
        });
    }
}
