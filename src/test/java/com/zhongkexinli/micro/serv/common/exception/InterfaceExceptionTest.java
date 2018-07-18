package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class InterfaceExceptionTest {

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionTest() throws Exception{
		throw new InterfaceException();
	}

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionMsgTest() throws Exception{
		throw new InterfaceException("InterfaceException");
	}

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new InterfaceException(cause);
	}

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new InterfaceException("InterfaceException",cause);
	}

}
