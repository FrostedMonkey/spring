package demo16.parimary.first;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author : chenchen
 * @ClassName Service2
 * @date : 2020-07-20 16:01
 * @Description TODO
 **/
@Component
@Primary//表示这是个主要的候选者
public class Service2 implements IService {
}
