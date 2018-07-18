package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class InvalidateInputExceptionTest {

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionTest() throws Exception{
		throw new InvalidateInputException ();
	}

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionMsgTest() throws Exception{
		throw new InvalidateInputException ("InvalidateInputException");
	}

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionThrowTest()  throws Exception{
		Throwable cause = new Throwable();
		throw new InvalidateInputException (cause);
	}

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionThrowMsgTest() throws Exception{
		Throwable cause = new Throwable();
		throw new InvalidateInputException ("InvalidateInputException",cause);
	}
}
