package com.zhongkexinli.micro.serv.common.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RestAPIResultTest {

	@Test
	public void RestAPIResultTest1() {
		RestAPIResult restAPIResult = new RestAPIResult();
		assertTrue(restAPIResult.getRespCode()==1);
		assertEquals("成功",restAPIResult.getRespMsg());
	}
	
	@Test
	public void RestAPIResultTest2() {
		RestAPIResult restAPIResult = new RestAPIResult("okay");
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("okay",restAPIResult.getRespMsg());
	}
	
	@Test
	public void RestAPIResultTest3() {
		RestAPIResult restAPIResult = new RestAPIResult("okay");
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("okay",restAPIResult.getRespMsg());
		
		restAPIResult.error("error");
		
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("error",restAPIResult.getRespMsg());
	}
	
	@Test
	public void RestAPIResultTest4() {
		RestAPIResult restAPIResult = new RestAPIResult("okay");
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("okay",restAPIResult.getRespMsg());
		
		restAPIResult.error();
		
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("0",restAPIResult.getRespMsg());
	}

}
