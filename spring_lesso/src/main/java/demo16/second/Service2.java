package demo16.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 14:39
 * @Description TODO
 **/
@Component
public class Service2 {
    private Service1 service1;

    @Autowired
    public void injectService1(Service1 service1) { //@1方法上标注了@Autowired，spring容器会调用这个方法，从容器中查找Service1类型的bean，然后注入。
        System.out.println(this.getClass().getName() + ".injectService1()");
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
