package com.zhongkexinli.micro.serv.common.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void hasTextTest() {
		assertTrue(StringUtil.hasText("123"));
		assertTrue(StringUtil.hasText(" 123 "));
		assertTrue(StringUtil.hasText(" 123"));
		assertTrue(StringUtil.hasText("123 "));
		
		assertFalse(StringUtil.hasText(" "));
	}

}
