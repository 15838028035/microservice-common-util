package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

/**
 * 
 * 登陆密码错误异常
 *
 */
public class LoginUserPasswordErrorExceptionTest {

    @Test(expected = LoginUserPasswordErrorException.class)
    public void loginUserPasswordErrorExceptionTest() {
        throw new LoginUserPasswordErrorException();
    }

    @Test(expected = LoginUserPasswordErrorException.class)
    public void iloginUserPasswordErrorExceptionMsgTest() {
        throw new LoginUserPasswordErrorException("LoginUserPasswordErrorException");
    }

    @Test(expected = LoginUserPasswordErrorException.class)
    public void loginUserPasswordErrorExceptionThrowTest() {
        Throwable cause = new Throwable();
        throw new LoginUserPasswordErrorException(cause);
    }

    @Test(expected = LoginUserPasswordErrorException.class)
    public void loginUserPasswordErrorExceptionThrowMsgTest() {
        Throwable cause = new Throwable();
        throw new LoginUserPasswordErrorException("LoginUserPasswordErrorException", cause);
    }

}
