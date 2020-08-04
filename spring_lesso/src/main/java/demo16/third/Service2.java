package demo16.third;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 14:49
 * @Description TODO
 **/
@Component
public class Service2 {
    private Service1 service1;

    @Autowired
    public void setService1(Service1 service1) { //@1标准的set方法，方法上使用了 @Autowired，会通过这个方法注入Service1类型的bean对象。
        System.out.println(this.getClass().getName() + ".setService1方法");
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
