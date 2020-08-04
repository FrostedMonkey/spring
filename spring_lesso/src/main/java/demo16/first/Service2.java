package demo16.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 14:28
 * @Description TODO
 **/
@Component
public class Service2 {
    private Service1 service1;

    public Service2() { //@1无参构造器
        System.out.println(this.getClass() + "无参构造器");
    }
    @Autowired
    public Service2(Service1 service1) { //@2有参构造器，可以通过这个传入依赖的Service1
        System.out.println(this.getClass() + "有参构造器");
        this.service1 = service1;
    }

    @Override
    public String toString() { //@2
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
