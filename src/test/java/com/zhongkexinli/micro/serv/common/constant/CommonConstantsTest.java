package com.zhongkexinli.micro.serv.common.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CommonConstantsTest {

	@Test
	public void test() {
		assertSame("menu",CommonConstants.RESOURCE_TYPE_MENU);
		assertSame("button",CommonConstants.RESOURCE_TYPE_BTN);
		
		assertTrue(CommonConstants.EX_USER_INVALID_CODE>0);
		assertTrue(CommonConstants.EX_CLIENT_FORBIDDEN_CODE>0);
		assertTrue(CommonConstants.EX_OTHER_CODE>0);
		
		assertSame("currentUserId",CommonConstants.CONTEXT_KEY_USER_ID);
		assertSame("currentUserName",CommonConstants.CONTEXT_KEY_USERNAME);
		assertSame("currentUser",CommonConstants.CONTEXT_KEY_USER_NAME);
		
		assertSame("currentUserToken",CommonConstants.CONTEXT_KEY_USER_TOKEN);
		assertSame("userId",CommonConstants.JWT_KEY_USER_ID);
		assertSame("name",CommonConstants.JWT_KEY_NAME);
		assertSame("UTF-8",CommonConstants.ENCODING_UTF_8);
		
		assertSame("0",CommonConstants.FAIL);
		assertSame("成功",CommonConstants.SUCCESS_MSG);
		
		assertTrue(CommonConstants.ERROR==0);
		assertTrue(CommonConstants.SUCCESS==1);
	}

}
