package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class LoginUserPasswordErrorExceptionTest {

	@Test(expected = LoginUserPasswordErrorException.class)
	public void loginUserPasswordErrorExceptionTest() throws Exception{
		throw new LoginUserPasswordErrorException();
	}

	@Test(expected = LoginUserPasswordErrorException.class)
	public void iloginUserPasswordErrorExceptionMsgTest() throws Exception{
		throw new LoginUserPasswordErrorException("LoginUserPasswordErrorException");
	}

	@Test(expected = LoginUserPasswordErrorException.class)
	public void loginUserPasswordErrorExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new LoginUserPasswordErrorException(cause);
	}

	@Test(expected = LoginUserPasswordErrorException.class)
	public void loginUserPasswordErrorExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new LoginUserPasswordErrorException("LoginUserPasswordErrorException",cause);
	}

}
