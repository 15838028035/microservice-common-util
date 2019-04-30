package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class BusinessExceptionTest {
	
	@Test(expected = BusinessException.class)
	public void businessExceptionTest() {
		throw new BusinessException();
	}

	@Test(expected = BusinessException.class)
	public void businessExceptionMsgTest() {
		throw new BusinessException("BusinessException");
	}

	@Test(expected = BusinessException.class)
	public void businessExceptionThrowTest()  {
		Throwable cause = new Throwable();
		throw new BusinessException(cause);
	}

  @Test(expected = BusinessException.class)
  public void businessExceptionThrowMsgTest() {
  	Throwable cause = new Throwable();
  	throw new BusinessException("BusinessException",cause);
  }
}
