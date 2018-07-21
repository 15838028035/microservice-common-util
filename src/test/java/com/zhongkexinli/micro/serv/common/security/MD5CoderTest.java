package com.zhongkexinli.micro.serv.common.security;

import org.junit.Assert;
import org.junit.Test;

public class MD5CoderTest {

	@Test
	public void encodeMd5Test() throws Exception {
		String encodeData = "MD5加密数据";
		byte[]data1 = MD5Coder.encodeMd5(encodeData);
		byte[]data2 = MD5Coder.encodeMd5(encodeData);
		Assert.assertArrayEquals(data1, data2);
	}

	@Test
	public void md5DigestAsHexTest()  throws Exception {
		String encodeData = "MD5加密数据HEX";
		byte[]data1 = MD5Coder.md5DigestAsHex(encodeData);
		byte[]data2 = MD5Coder.md5DigestAsHex(encodeData);
		Assert.assertArrayEquals(data1, data2);
		
	}

}
