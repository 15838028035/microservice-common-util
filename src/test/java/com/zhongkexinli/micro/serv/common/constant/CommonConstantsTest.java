package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonConstantsTest {

	@Test
	public void test() {
		assertEquals("menu",CommonConstants.RESOURCE_TYPE_MENU);
		assertEquals("button",CommonConstants.RESOURCE_TYPE_BTN);
		
		assertTrue(CommonConstants.EX_USER_INVALID_CODE>0);
		assertTrue(CommonConstants.EX_CLIENT_FORBIDDEN_CODE>0);
		assertTrue(CommonConstants.EX_OTHER_CODE>0);
		
		assertEquals("currentUserId",CommonConstants.CONTEXT_KEY_USER_ID);
		assertEquals("currentUserName",CommonConstants.CONTEXT_KEY_USERNAME);
		assertEquals("currentUser",CommonConstants.CONTEXT_KEY_USER_NAME);
		
		assertEquals("currentUserToken",CommonConstants.CONTEXT_KEY_USER_TOKEN);
		assertEquals("userId",CommonConstants.JWT_KEY_USER_ID);
		assertEquals("name",CommonConstants.JWT_KEY_NAME);
		assertEquals("UTF-8",CommonConstants.ENCODING_UTF_8);
		
		
		assertEquals("0",CommonConstants.FAIL);
		assertEquals("成功",CommonConstants.SUCCESS_MSG);
		
		assertTrue(CommonConstants.ERROR==0);
		assertTrue(CommonConstants.SUCCESS==1);
	}

}
