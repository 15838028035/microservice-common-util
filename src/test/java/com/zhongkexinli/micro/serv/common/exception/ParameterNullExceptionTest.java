package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class ParameterNullExceptionTest {

	@Test(expected = ParameterNullException.class)
	public void parameterNullExceptionTest() throws Exception{
		throw new ParameterNullException();
	}

	@Test(expected = ParameterNullException.class)
	public void parameterNullExceptionMsgTest() throws Exception{
		throw new ParameterNullException("ParameterNullException");
	}

	@Test(expected = ParameterNullException.class)
	public void parameterNullExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new ParameterNullException(cause);
	}

	@Test(expected = ParameterNullException.class)
	public void parameterNullExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new ParameterNullException("ParameterNullException",cause);
	}

}
