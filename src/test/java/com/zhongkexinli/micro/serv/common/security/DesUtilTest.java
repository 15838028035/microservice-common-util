package com.zhongkexinli.micro.serv.common.security;

import org.junit.Test;

public class DesUtilTest {


	@Test
	public void sysadminEncryptTest() throws Exception{
		String sysadmin = DesUtil.encrypt("root");
		System.out.println("sysadmin=" +sysadmin);
	}
}
