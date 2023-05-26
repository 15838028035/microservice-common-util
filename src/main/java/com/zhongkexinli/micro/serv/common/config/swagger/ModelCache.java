package com.zhongkexinli.micro.serv.common.config.swagger;
 
import java.util.HashMap;
import java.util.Map;

import io.swagger.models.Model;
 
public class ModelCache {
 
    public static final Map<String, Model> extra_cache = new HashMap<>();
 
    public  static  final Map<String, Value2<String,String[]>> specified_cache = new HashMap<>();
 
}