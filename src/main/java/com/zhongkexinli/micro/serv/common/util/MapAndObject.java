package com.zhongkexinli.micro.serv.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;

/**
 * 自定义封装map
 *
 */
public class MapAndObject implements Map {

    private static Log logger = LogFactory.getLog(MapAndObject.class);

    private Map map;
    private Object bean;

    public MapAndObject(Map map, Object bean) {
        this.map = map;
        this.bean = bean;
    }

    public Map getMap() {
        return this.map;
    }

    public Object getBean() {
        return this.bean;
    }

    @Override
    public Object get(Object key) {
        return getFromMapOrBean(key);
    }

    Object getFromMapOrBean(Object key) {
        Object result = null;
        if (this.map != null) {
            return this.map.get(key);
        }

        if (this.bean instanceof Map) {
            return ((Map) this.bean).get(key);
        }

        if (this.bean != null && (key instanceof String)) {
            String propertyName = (String) key;
            Object fastObj = FastPropertyUtils.getBeanPropertyValue(this.bean, propertyName);
            if (fastObj instanceof String) {
                fastObj = ((String) fastObj).trim();
            }
            return fastObj;
        }
        return result;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object put(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection values() {
        throw new UnsupportedOperationException();
    }

    private static class FastPropertyUtils {

        private FastPropertyUtils() {

        }

        private static Object getBeanPropertyValue(Object bean, String propertyName) {
            if (bean == null) {
                throw new IllegalArgumentException("bean cannot be not null");
            }
            if (propertyName == null) {
                throw new IllegalArgumentException("propertyName cannot be not null");
            }
            try {
                Method readMethod = getReadMethod(bean, propertyName);
                if (readMethod == null) {
                    return null;
                }
                return readMethod.invoke(bean, new Object[0]);
            } catch (IllegalAccessException e) {
                logger.error(e);
                throw new IllegalStateException(
                        "cannot get property value by property:" + propertyName + " on class:" + bean.getClass(), e);
            } catch (InvocationTargetException e) {
                logger.error(e);
                throw new IllegalStateException(
                        "cannot get property value by property:" + propertyName + " on class:" + bean.getClass(),
                        e.getTargetException());
            }

        }

        private static Method getReadMethod(Object bean, String propertyName) {
            return BeanUtils.getPropertyDescriptor(bean.getClass(), propertyName).getReadMethod();
        }
    }
}