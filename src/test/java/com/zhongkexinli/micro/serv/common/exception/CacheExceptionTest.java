package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;


/**
 * 
 * 缓存异常
 *
 */
public class CacheExceptionTest {

    @Test(expected = CacheException.class)
    public void cacheExceptionTest() {
        throw new CacheException();
    }

    @Test(expected = CacheException.class)
    public void cacheExceptionConTest() {
        throw new CacheException("CacheException");
    }

    @Test(expected = CacheException.class)
    public void cacheExceptionThrowTest() {
        Throwable cause = new Throwable();
        throw new CacheException(cause);
    }

    @Test(expected = CacheException.class)
    public void cacheExceptionMsgTest() {
        Throwable cause = new Throwable();
        throw new CacheException("CacheException", cause);
    }

}
