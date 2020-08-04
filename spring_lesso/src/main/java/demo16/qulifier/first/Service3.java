package demo16.qulifier.first;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service3
 * @date : 2020-07-20 15:47
 * @Description TODO
 **/
@Component
@Qualifier("tag2")//@1
public class Service3 implements IService{
}
