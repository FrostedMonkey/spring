package demo16.resource.first;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 15:41
 * @Description TODO
 **/
@Component
public class Service2 {

    @Resource
    private IService service1;//字段名称为service1，按照字段名称查找bean，会找到Service1

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
