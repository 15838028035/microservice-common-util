package com.zhongkexinli.micro.serv.common.config.swagger;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiResponseFields {
 
    String modelName() default "";
 
    String[] fields();
}