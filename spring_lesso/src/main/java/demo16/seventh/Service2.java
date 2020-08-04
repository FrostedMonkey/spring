package demo16.seventh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 15:27
 * @Description TODO
 **/

@Component
public class Service2 {

    @Autowired
    private List<IService> services;

    @Autowired
    private Map<String, IService> serviceMap;

    @Override
    public String toString() {
        return "Service2{\n" +
                "services=" + services +
                ", \n serviceMap=" + serviceMap +
                '}';
    }
}

