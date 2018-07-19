package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RestCodeConstantsTest {

	@Test
	public void test() {
		assertTrue(RestCodeConstants.TOKEN_ERROR_CODE>0);
		assertTrue(RestCodeConstants.TOKEN_FORBIDDEN_CODE>0);
	}

}
