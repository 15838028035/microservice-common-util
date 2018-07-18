package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class LoginUserNotExistsExceptionTest {

	@Test(expected = LoginUserNotExistsException.class)
	public void loginUserNotExistsExceptionTest() throws Exception{
		throw new LoginUserNotExistsException();
	}

	@Test(expected = LoginUserNotExistsException.class)
	public void loginUserNotExistsExceptionnMsgTest() throws Exception{
		throw new LoginUserNotExistsException("LoginUserNotExistsException");
	}

	@Test(expected = LoginUserNotExistsException.class)
	public void loginUserNotExistsExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new LoginUserNotExistsException(cause);
	}

	@Test(expected = LoginUserNotExistsException.class)
	public void loginUserNotExistsExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new LoginUserNotExistsException("LoginUserNotExistsException",cause);
	}
}
