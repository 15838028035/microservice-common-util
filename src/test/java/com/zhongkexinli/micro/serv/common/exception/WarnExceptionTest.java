package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class WarnExceptionTest {

	@Test(expected = WarnException.class)
	public void warnExceptionTest() throws Exception{
		throw new WarnException();
	}

	@Test(expected = WarnException.class)
	public void WarnExceptiongTest() throws Exception{
		throw new WarnException("WarnException");
	}

	@Test(expected = WarnException.class)
	public void WarnExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new WarnException(cause);
	}

	@Test(expected = WarnException.class)
	public void WarnExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new WarnException("WarnException",cause);
	}

}
