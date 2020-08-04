package com.cc.config;

import com.cc.bean.Yellow;
/*import com.mchange.v2.c3p0.ComboPooledDataSource;*/
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @ClassName MainconfigOfProfile
 * @Author chenchen
 * @Date 2019/11/7 22:26
 * @Version 1.0
 * profile:
 *      spring :提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 * 开发环境、测试环境、生产环境
 * 比如数据源（/A：开发环境/B：测试环境/C：生产环境）
 * @profile:指定组件在那个环境的情况下才能被注册到容器中，不指定，任何环境都能注册这个组件
 * 1)、加了环境标识的bean 只有在这个环境才会被注册到容器中 默认是default环境
 * 2）、写在配置类上、只有是指定的环境的时候，整个配置类里面的所有配置才会生效。
 * 3）、没有标注环境表示的bean在任何环境下都是加载的
 **/
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainconfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${user}")
    private String user;
    private String driverClass;
    private StringValueResolver valueResolver;
    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }


    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/depot");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("dev")
    @Bean("DevDataSource")
    public DataSource dataSourceDevelop(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prjdb");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }
    @Profile("prod")
    @Bean("ProdDataSource")
    public DataSource dataSourceProduct(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/twenty");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver=resolver;
        driverClass=valueResolver.resolveStringValue("${db.driverClass}");
    }
}
