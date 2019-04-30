package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class WarnExceptionTest {

	@Test(expected = WarnException.class)
	public void warnExceptionTest() {
		throw new WarnException();
	}

	@Test(expected = WarnException.class)
	public void warnExceptiongTest() {
		throw new WarnException("WarnException");
	}

	@Test(expected = WarnException.class)
	public void warnExceptionThrowTest()  {
		Throwable cause = new Throwable();
		throw new WarnException(cause);
	}

	@Test(expected = WarnException.class)
	public void warnExceptionThrowMsgTest(){
		Throwable cause = new Throwable();
		throw new WarnException("WarnException",cause);
	}

}
