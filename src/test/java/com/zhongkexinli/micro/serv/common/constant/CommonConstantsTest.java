package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonConstantsTest {

	@Test
	public void test() {
		assertEquals("menu",CommonConstants.RESOURCE_TYPE_MENU,"excepted menu");
		assertEquals("button",CommonConstants.RESOURCE_TYPE_BTN,"excepted button");
		
		assertTrue(CommonConstants.EX_USER_INVALID_CODE>0);
		assertTrue(CommonConstants.EX_CLIENT_FORBIDDEN_CODE>0);
		assertTrue(CommonConstants.EX_OTHER_CODE>0);
		
		assertEquals("currentUserId",CommonConstants.CONTEXT_KEY_USER_ID,"excepted currentUserId");
		assertEquals("currentUserName",CommonConstants.CONTEXT_KEY_USERNAME,"excepted currentUserName");
		assertEquals("currentUser",CommonConstants.CONTEXT_KEY_USER_NAME,"excepted currentUser");
		
		assertEquals("currentUserToken",CommonConstants.CONTEXT_KEY_USER_TOKEN,"excepted currentUserToken");
		assertEquals("userId",CommonConstants.JWT_KEY_USER_ID,"excepted userId");
		assertEquals("name",CommonConstants.JWT_KEY_NAME,"excepted name");
		assertEquals("UTF-8",CommonConstants.ENCODING_UTF_8,"excepted UTF-8");
		
		
		assertEquals("0",CommonConstants.FAIL,"excepted 0");
		assertEquals("成功",CommonConstants.SUCCESS_MSG,"excepted 成功");
		
		assertTrue(CommonConstants.ERROR==0);
		assertTrue(CommonConstants.SUCCESS==1);
	}

}
