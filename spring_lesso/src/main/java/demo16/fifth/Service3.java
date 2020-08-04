package demo16.fifth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service3
 * @date : 2020-07-20 15:09
 * @Description TODO
 **/
@Component
public class Service3 {
    @Autowired
    private Service1 service1;//@1

    @Autowired
    private Service2 service2;//@2

    @Override
    public String toString() {
        return "Service3{" +
                "service1=" + service1 +
                ", service2=" + service2 +
                '}';
    }
}
