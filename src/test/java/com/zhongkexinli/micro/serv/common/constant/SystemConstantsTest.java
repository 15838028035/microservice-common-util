package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SystemConstantsTest {

	@Test
	public void test() {
		assertEquals("1",SystemConstants.Code.SUCCESS);
		assertEquals("0",SystemConstants.Code.FAIL);
		assertTrue(SystemConstants.Code.success==1);
		assertTrue(SystemConstants.Code.error==0);
	}

}
