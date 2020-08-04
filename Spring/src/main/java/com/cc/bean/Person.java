package com.cc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName Person
 * @Author chenchen
 * @Date 2019/9/8 22:11
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    /**
     * 使用@Value
     * 1、几本书只
     * 2、使用SpEL #{}
     * 3、${}取配置文件中的值（在运行环境变量中的值）
     */
    @Value("chenchen")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${person.EnglistName}")
    private String EnglishName;
}
