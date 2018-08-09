package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonConstantsTest {

	@Test
	public void test() {
		assertEquals(CommonConstants.RESOURCE_TYPE_MENU,"menu");
		assertEquals(CommonConstants.RESOURCE_TYPE_BTN,"button");
		
		assertTrue(CommonConstants.EX_USER_INVALID_CODE>0);
		assertTrue(CommonConstants.EX_CLIENT_FORBIDDEN_CODE>0);
		assertTrue(CommonConstants.EX_OTHER_CODE>0);
		
		assertEquals(CommonConstants.CONTEXT_KEY_USER_ID,"currentUserId");
		assertEquals(CommonConstants.CONTEXT_KEY_USERNAME,"currentUserName");
		assertEquals(CommonConstants.CONTEXT_KEY_USER_NAME,"currentUser");
		
		assertEquals(CommonConstants.CONTEXT_KEY_USER_TOKEN,"currentUserToken");
		assertEquals(CommonConstants.JWT_KEY_USER_ID,"userId");
		assertEquals(CommonConstants.JWT_KEY_NAME,"name");
		assertEquals(CommonConstants.ENCODING_UTF_8,"UTF-8");
		
		
		assertEquals(CommonConstants.FAIL,"0");
		assertEquals(CommonConstants.SUCCESS_MSG,"成功");
		
		assertTrue(CommonConstants.ERROR==0);
		assertTrue(CommonConstants.SUCCESS==1);
	}

}
