package demo16.parimary.second;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : chenchen
 * @ClassName InjectService
 * @date : 2020-07-20 16:05
 * @Description TODO
 **/
public class InjectService {
    @Autowired
    private IService service1;//@1

    @Override
    public String toString() {
        return "InjectService{" +
                "service1=" + service1 +
                '}';
    }
}
