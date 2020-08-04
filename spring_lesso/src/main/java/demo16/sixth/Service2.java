package demo16.sixth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 15:15
 * @Description TODO
 **/
@Component
public class Service2 {

    /**
     * 标注了@Autowired注解，需要注入类型为IService类型的bean，满足这种类型的有2个：service0和service1
     * 按照上面介绍的候选者查找过程，最后会注入和字段名称一样的bean，即：service1
     */
    @Autowired
    private IService service1; //@1

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
