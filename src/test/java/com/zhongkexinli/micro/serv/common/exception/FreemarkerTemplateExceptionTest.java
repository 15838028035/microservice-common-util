package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class FreemarkerTemplateExceptionTest {
	@Test(expected = FreemarkerTemplateException.class)
	public void freemarkerTemplateExceptionTest() throws Exception{
		throw new FreemarkerTemplateException();
	}

	@Test(expected = FreemarkerTemplateException.class)
	public void freemarkerTemplateExceptionExceptionTest() throws Exception{
		throw new FreemarkerTemplateException("FreemarkerTemplateException");
	}

	@Test(expected = FreemarkerTemplateException.class)
	public void freemarkerTemplateExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new FreemarkerTemplateException(cause);
	}

	@Test(expected = FreemarkerTemplateException.class)
	public void freemarkerTemplateExceptionMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new FreemarkerTemplateException("FreemarkerTemplateException",cause);
	}


}
