package com.zhongkexinli.micro.serv.common.security;

import org.junit.Test;

import com.zhongkexinli.micro.serv.common.exception.EcnodeDecodeException;

public class DesUtilTest {

	@Test
	public void sysadminEncryptTest() throws EcnodeDecodeException {
		 DesUtil.encrypt("root");
	}
}
