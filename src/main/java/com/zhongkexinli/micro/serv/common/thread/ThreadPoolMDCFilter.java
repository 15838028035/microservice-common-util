package com.zhongkexinli.micro.serv.common.thread;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.slf4j.MDC;
 
/**
 * @Classname ThreadPoolMDCFilter
 * @Description 多线程MDC塞入
 */
public class ThreadPoolMDCFilter {
    
    private ThreadPoolMDCFilter() {
        //空实现
    }
 
    public static void setSleuthTraceId(){
        
        String traceId = MDC.get("traceId");
        
        if(traceId == null) {
            String uuid =  UUID.randomUUID().toString();
            MDC.put("traceId", uuid);
        }
        
    }
 
    public static <T> Callable<T> wrap(final Callable<T> callable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setSleuthTraceId();
            try {
                return callable.call();
            } finally {
                MDC.clear();
            }
        };
    }
 
    public static Runnable wrap(final Runnable runnable, final Map<String, String> context) {
        return () -> {
            if (context == null) {
                MDC.clear();
            } else {
                MDC.setContextMap(context);
            }
            setSleuthTraceId();
            try {
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
 
}
