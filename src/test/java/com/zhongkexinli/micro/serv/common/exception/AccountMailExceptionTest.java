package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

/**
 * 
 * 帐号邮箱异常
 *
 */
public class AccountMailExceptionTest {

    @Test(expected = AccountMailException.class)
    public void accountMailExceptionTest() {
        throw new AccountMailException();
    }

    @Test(expected = AccountMailException.class)
    public void accountMailExceptionExceptionTest() {
        throw new AccountMailException("AccountMailException");
    }

    @Test(expected = AccountMailException.class)
    public void accountMailExceptionExceptionThrowTest() {
        Throwable cause = new Throwable();
        throw new AccountMailException(cause);
    }

    @Test(expected = AccountMailException.class)
    public void accountMailExceptionExceptionMsgTest() {
        Throwable cause = new Throwable();
        throw new AccountMailException("AccountMailException", cause);
    }

}
