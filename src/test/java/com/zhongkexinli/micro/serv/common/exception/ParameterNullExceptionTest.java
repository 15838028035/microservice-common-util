package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;
/**
 * 
 * 参数为空异常
 *
 */
public class ParameterNullExceptionTest {

    @Test(expected = ParameterNullException.class)
    public void parameterNullExceptionTest() {
        throw new ParameterNullException();
    }

    @Test(expected = ParameterNullException.class)
    public void parameterNullExceptionMsgTest() {
        throw new ParameterNullException("ParameterNullException");
    }

    @Test(expected = ParameterNullException.class)
    public void parameterNullExceptionThrowTest() {
        Throwable cause = new Throwable();
        throw new ParameterNullException(cause);
    }

    @Test(expected = ParameterNullException.class)
    public void parameterNullExceptionThrowMsgTest() {
        Throwable cause = new Throwable();
        throw new ParameterNullException("ParameterNullException", cause);
    }

}
