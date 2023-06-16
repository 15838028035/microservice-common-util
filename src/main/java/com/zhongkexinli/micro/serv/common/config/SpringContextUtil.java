package com.zhongkexinli.micro.serv.common.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * SpringContext
 *
 * @data 2020/12/10
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }
    
    /**
     * 获取applicationContext
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * Gets bean.
     *
     * @param beanId the bean id
     * @return the bean
     */
    public static Object getBean(String beanId) {
        return getApplicationContext().getBean(beanId);
    }
    
    /**
     * Gets bean.
     *
     * @param beanId the bean id
     * @return the bean
     */
    public static Object getBeanClass( Class requiredType) {
        return getApplicationContext().getBean(requiredType);
    }
}
