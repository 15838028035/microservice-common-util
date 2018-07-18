package com.zhongkexinli.micro.serv.common.msg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BaseResponseTest {
	@Test
	public void baseResponseTest1() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatus(200);
		baseResponse.setMessage("okay");
		assertTrue(baseResponse.getStatus()==200);
		assertEquals("okay",baseResponse.getMessage());
	}
	
	@Test
	public void baseResponseTest2() {
		BaseResponse baseResponse = new BaseResponse(200,"okay");
		assertTrue(baseResponse.getStatus()==200);
		assertEquals("okay",baseResponse.getMessage());
	}

}
