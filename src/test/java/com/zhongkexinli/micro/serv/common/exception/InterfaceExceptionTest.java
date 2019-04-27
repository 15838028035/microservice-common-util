package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class InterfaceExceptionTest {

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionTest() {
		throw new InterfaceException();
	}

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionMsgTest() {
		throw new InterfaceException("InterfaceException");
	}

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionThrowTest()  {
		Throwable cause = new Throwable();
		throw new InterfaceException(cause);
	}

	@Test(expected = InterfaceException.class)
	public void interfaceExceptionThrowMsgTest(){
		Throwable cause = new Throwable();
		throw new InterfaceException("InterfaceException",cause);
	}

}
