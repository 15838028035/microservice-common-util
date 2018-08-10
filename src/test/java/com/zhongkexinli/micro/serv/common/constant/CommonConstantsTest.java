package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonConstantsTest {

	@Test
	public void test() {
		assertEquals("excepted menu","menu",CommonConstants.RESOURCE_TYPE_MENU);
		assertEquals("excepted button","button",CommonConstants.RESOURCE_TYPE_BTN);
		
		assertTrue(CommonConstants.EX_USER_INVALID_CODE>0);
		assertTrue(CommonConstants.EX_CLIENT_FORBIDDEN_CODE>0);
		assertTrue(CommonConstants.EX_OTHER_CODE>0);
		
		assertEquals("excepted currentUserId","currentUserId",CommonConstants.CONTEXT_KEY_USER_ID);
		assertEquals("excepted currentUserName","currentUserName",CommonConstants.CONTEXT_KEY_USERNAME);
		assertEquals("excepted currentUser","currentUser",CommonConstants.CONTEXT_KEY_USER_NAME);
		
		assertEquals("excepted currentUserToken","currentUserToken",CommonConstants.CONTEXT_KEY_USER_TOKEN);
		assertEquals("excepted userId","userId",CommonConstants.JWT_KEY_USER_ID);
		assertEquals("excepted name","name",CommonConstants.JWT_KEY_NAME);
		assertEquals("excepted UTF-8","UTF-8",CommonConstants.ENCODING_UTF_8);
		
		
		assertEquals("excepted 0","0",CommonConstants.FAIL);
		assertEquals("excepted 成功","成功",CommonConstants.SUCCESS_MSG);
		
		assertTrue(CommonConstants.ERROR==0);
		assertTrue(CommonConstants.SUCCESS==1);
	}

}
