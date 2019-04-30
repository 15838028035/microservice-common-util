package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class InvalidateInputExceptionTest {

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionTest() {
		throw new InvalidateInputException();
	}

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionMsgTest() {
		throw new InvalidateInputException("InvalidateInputException");
	}

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionThrowTest()  {
		Throwable cause = new Throwable();
		throw new InvalidateInputException(cause);
	}

	@Test(expected = InvalidateInputException .class)
	public void invalidateInputExceptionThrowMsgTest() {
		Throwable cause = new Throwable();
		throw new InvalidateInputException ("InvalidateInputException",cause);
	}
}
