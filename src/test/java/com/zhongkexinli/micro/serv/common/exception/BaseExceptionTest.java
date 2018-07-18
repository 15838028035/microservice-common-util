package com.zhongkexinli.micro.serv.common.exception;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BaseExceptionTest {
	
	@Test(expected = BaseException.class)
	public void baseExceptionExceptionTest() throws Exception{
		throw new BaseException();
	}

	@Test(expected = BaseException.class)
	public void baseExceptionExceptionMsgTest() throws Exception{
		throw new BaseException("BaseException");
	}

	@Test(expected = BaseException.class)
	public void baseExceptionExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new BaseException(cause);
	}

	@Test(expected = BaseException.class)
	public void baseExceptionExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new BaseException("BaseException",cause);
	}
	
	@Test(expected = BaseException.class)
	public void baseExceptionTest5() throws Exception{
		BaseException baseException = new BaseException();
		baseException.setStatus(200);
		assertTrue(baseException.getStatus()==200);
		throw baseException;
	}

}
