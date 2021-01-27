package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;


/**
 * 
 * 模板异常
 *
 */
public class FreemarkerTemplateExceptionTest {
    @Test(expected = FreemarkerTemplateException.class)
    public void freemarkerTemplateExceptionTest() {
        throw new FreemarkerTemplateException();
    }

    @Test(expected = FreemarkerTemplateException.class)
    public void freemarkerTemplateExceptionExceptionTest() {
        throw new FreemarkerTemplateException("FreemarkerTemplateException");
    }

    @Test(expected = FreemarkerTemplateException.class)
    public void freemarkerTemplateExceptionThrowTest() {
        Throwable cause = new Throwable();
        throw new FreemarkerTemplateException(cause);
    }

    @Test(expected = FreemarkerTemplateException.class)
    public void freemarkerTemplateExceptionMsgTest() {
        Throwable cause = new Throwable();
        throw new FreemarkerTemplateException("FreemarkerTemplateException", cause);
    }

}
