package demo16.qulifier.first;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service1
 * @date : 2020-07-20 15:46
 * @Description TODO
 **/
@Component
@Qualifier("tag1") //@1
public class Service1 implements IService {
}
