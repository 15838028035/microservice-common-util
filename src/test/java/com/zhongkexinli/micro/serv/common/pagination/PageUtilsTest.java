package com.zhongkexinli.micro.serv.common.pagination;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PageUtilsTest {

	@Test
	public void computeLastPageNumberTest() {
		assertEquals(1,PageUtils.computeLastPageNumber(10, 10));
		assertEquals(2,PageUtils.computeLastPageNumber(11, 10));
		assertEquals(11,PageUtils.computeLastPageNumber(101, 10));
	}
}
