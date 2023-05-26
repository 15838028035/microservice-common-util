package com.zhongkexinli.micro.serv.common.config.swagger;
 
public @interface ApiResponseProperty {
 
    String name();
 
    String description() default "";
 
    String type();
 
}