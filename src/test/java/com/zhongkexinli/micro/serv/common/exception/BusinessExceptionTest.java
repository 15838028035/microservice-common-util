package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class BusinessExceptionTest {
	
	@Test(expected = BusinessException.class)
	public void businessExceptionTest() throws Exception{
		throw new BusinessException();
	}

	@Test(expected = BusinessException.class)
	public void businessExceptionMsgTest() throws Exception{
		throw new BusinessException("BusinessException");
	}

	@Test(expected = BusinessException.class)
	public void businessExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new BusinessException(cause);
	}

	@Test(expected = BusinessException.class)
	public void businessExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new BusinessException("BusinessException",cause);
	}
}
