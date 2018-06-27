package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SHA1UtilTest {

	/**
	 * SHA1 测试
	 */
	@Test
	public void SHA1Test() {
		assertNotNull(SHA1Util.SHA1("123456"));
	}

}
