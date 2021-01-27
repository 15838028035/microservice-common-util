package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

/**
 * 
 * 登陆用户不存在异常
 *
 */
public class LoginUserNotExistsExceptionTest {

    @Test(expected = LoginUserNotExistsException.class)
    public void loginUserNotExistsExceptionTest() {
        throw new LoginUserNotExistsException();
    }

    @Test(expected = LoginUserNotExistsException.class)
    public void loginUserNotExistsExceptionnMsgTest() {
        throw new LoginUserNotExistsException("LoginUserNotExistsException");
    }

    @Test(expected = LoginUserNotExistsException.class)
    public void loginUserNotExistsExceptionThrowTest() {
        Throwable cause = new Throwable();
        throw new LoginUserNotExistsException(cause);
    }

    @Test(expected = LoginUserNotExistsException.class)
    public void loginUserNotExistsExceptionThrowMsgTest() {
        Throwable cause = new Throwable();
        throw new LoginUserNotExistsException("LoginUserNotExistsException", cause);
    }
}
