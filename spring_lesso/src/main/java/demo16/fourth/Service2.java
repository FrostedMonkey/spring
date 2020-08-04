package demo16.fourth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 15:00
 * @Description TODO
 **/
@Component
public class Service2 {

    private Service1 service1;

    @Autowired
    /**
     * 方法上标注了@Autowired，表示会将这个方法作为注入方法，这个方法有2个参数，spring查找这2个参数对应的bean，然后注入。
     * 第一个参数对应的bean是存在的，第二个是一个String类型的，我们并没有定义String类型bean，一会看看效果
     */
    public void injectService1(Service1 service1, @Autowired(required = false) String name) { //@1
        System.out.println(String.format("%s.injectService1(),{service1=%s,name=%s}", this.getClass().getName(), service1, name));
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
