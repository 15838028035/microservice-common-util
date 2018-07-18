package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class AccountMailExceptionTest {

	@Test(expected = AccountMailException.class)
	public void accountMailExceptionTest() throws Exception{
		throw new AccountMailException();
	}

	@Test(expected = AccountMailException.class)
	public void accountMailExceptionExceptionTest() throws Exception{
		throw new AccountMailException("AccountMailException");
	}

	@Test(expected = AccountMailException.class)
	public void accountMailExceptionExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new AccountMailException(cause);
	}

	@Test(expected = AccountMailException.class)
	public void accountMailExceptionExceptionMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new AccountMailException("AccountMailException",cause);
	}

}
