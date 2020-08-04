package demo16.qulifier.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName InjectService
 * @date : 2020-07-20 15:55
 * @Description TODO
 **/
@Component
public class InjectService {
    /**
     * 这里限定符的值为service2，容器中IService类型的bean有2个[service1和service2]，
     * 当类上没有标注@Qualifier注解的时候，可以理解为：bean的名称就是限定符的值
     * ，所以这里会匹配到service2
     */
    @Autowired
    @Qualifier("service2") //@1
    private IService service;

    @Override
    public String toString() {
        return "InjectService{" +
                "service=" + service +
                '}';
    }
}
