package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.util.DigestUtils;

/**
 * 
 * 加密测试
 */
public class DigestUtilsTest {

    @Test
    public void md5DigestTest() {
        String str = DigestUtils.md5DigestAsHex(new byte[] { 'A', 'B', 'C' });
        assertNotNull(str);
    }

    @Test
    public void md5DigestAsHexTest() {
        String str = DigestUtils.md5DigestAsHex(new byte[] { 'A', 'B', 'C' });
        assertNotNull(str);
    }

    @Test
    public void appendMd5DigestAsHexTest() {
        StringBuilder builder = new StringBuilder();
        builder = DigestUtils.appendMd5DigestAsHex(new byte[] { 'A', 'B' }, builder);
        assertNotNull(builder);
    }

}
