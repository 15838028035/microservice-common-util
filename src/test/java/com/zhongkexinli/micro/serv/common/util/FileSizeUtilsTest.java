package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.zhongkexinli.micro.serv.common.util.FileSizeUtils;

/**
 * 
 * 文件大小工具类
 *
 */
public class FileSizeUtilsTest {

    @Test
    public void testGetHumanReadableFileSize() {
        assertEquals("0", FileSizeUtils.getHumanReadableFileSize(0));
        assertEquals("1.12KB", FileSizeUtils.getHumanReadableFileSize(1024 + 124 + 1));
        assertEquals("2MB", FileSizeUtils.getHumanReadableFileSize(1024 * 1024 * 2 + 8));
        assertEquals("1GB", FileSizeUtils.getHumanReadableFileSize(1024 * 1024 * 1024));
        long tb = (long) 1024 * 1024 * 1024 * 1024 * 5;
        assertEquals("5TB", FileSizeUtils.getHumanReadableFileSize(tb + 8));
        assertEquals("8192PB", FileSizeUtils.getHumanReadableFileSize(Long.MAX_VALUE));

        assertEquals("-1", FileSizeUtils.getHumanReadableFileSize(-1));
        assertEquals("-1000000", FileSizeUtils.getHumanReadableFileSize(-1000000));

        assertNull(FileSizeUtils.getHumanReadableFileSize(null));
    }

}
