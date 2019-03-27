package com.zhongkexinli.micro.serv.common.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RestAPIResult2Test {

	@Test
	public void RestAPIResultTest4() {
	  RestAPIResult2 restAPIResult = new RestAPIResult2("okay");
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("okay",restAPIResult.getRespMsg());
		
		
		restAPIResult.messageFormat("错误了,{0}", "真的错了");
		
		assertEquals("错误了,真的错了",restAPIResult.getRespMsg());
	}

}
