package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class CacheExceptionTest {

	@Test(expected = CacheException.class)
	public void cacheExceptionTest() throws Exception{
		throw new CacheException();
	}

	@Test(expected = CacheException.class)
	public void CacheExceptionTest() throws Exception{
		throw new CacheException("CacheException");
	}

	@Test(expected = CacheException.class)
	public void CacheExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new CacheException(cause);
	}

	@Test(expected = CacheException.class)
	public void CacheExceptionMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new CacheException("CacheException",cause);
	}

}
