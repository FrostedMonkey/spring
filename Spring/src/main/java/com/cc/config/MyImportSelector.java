package com.cc.config;

import com.cc.bean.Blue;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportSelector
 * @Author chenchen
 * @Date 2019/9/10 21:44
 * @Version 1.0
 * 自定义逻辑返回需要导入的组件
 **/
public class MyImportSelector  implements ImportSelector {
    /**
     * 返回值就是导入到容器中的组件全类名
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //方法不能返回null值
        return new String[] {"com.cc.bean.Blue","com.cc.bean.Yellow"};
    }
}
