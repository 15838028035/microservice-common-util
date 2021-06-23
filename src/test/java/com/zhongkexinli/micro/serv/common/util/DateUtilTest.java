package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 日期工具类
 *
 */
public class DateUtilTest {

    @Test
    public void getNowDateYYYYMMddHHMMSSTest() {
        String date = DateUtil.getNowDateYYYYMMddHHMMSS();
        assertEquals(19,date.length());
    }

    @Test
    public void getNowDateTest() {
        String date = DateUtil.getNowDate("yyyy-MM-dd");
        assertEquals(10,date.length());
    }

    @Test
    public void formatDateTest() {
        assertEquals("2015-11-01",
                (DateUtil.formatDate(DateUtil.formatDate("2015-11-01", "yyyy-MM-dd"), "yyyy-MM-dd")));
        assertEquals("2015-10-01 00:00:00",
                (DateUtil.formatDate(DateUtil.formatDate("2015-10-01", "yyyy-MM-dd"), "yyyy-MM-dd HH:mm:ss")));
        assertEquals("00:00:00", (DateUtil.formatDate(DateUtil.formatDate("2015-12-01", "yyyy-MM-dd"), "HH:mm:ss")));

        assertEquals(null, (DateUtil.formatDate(DateUtil.formatDate("2015-01-01", "yyyy-MM-dd"), "bad format")));
    }

    @Test
    public void formatDateDateTest() {
        assertNotNull(DateUtil.formatDate("2015-10-01", "yyyy-MM-dd"));
        assertNotNull(DateUtil.formatDate("2015-10-01 10:00:00", "yyyy-MM-dd HH:mm:ss"));
        assertNotNull(DateUtil.formatDate("10:00:00", "HH:mm:ss"));

        assertNull(DateUtil.formatDate("", "yyyy-MM-dd"));
        assertNull(DateUtil.formatDate(" ", "yyyy-MM-dd"));
        assertNull(DateUtil.formatDate("bad date", "yyyy-MM-dd"));
    }

    @Test
    public void formatDateDateExceptionTest() {
        try {
            assertNull(DateUtil.formatDate("2015-10-01 10:00:00", "bad format"));
        } catch (IllegalArgumentException e) {
            
        }
    }

    @Test
    public void formatDateDateWidthBadFormatTest() {
        try {
            Date date = DateUtil.formatDate("2015-10-01 10:00:00", "yyyy-MM-dd gg ff");
            assertNull(date);
            Assert.fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IllegalArgumentException e) {
            
        }
    }

    @Test
    public void getIntervalDaysTest() {
        int interDays = DateUtil.getIntervalDays("2015-08-10 00:00:00", "2015-08-05 00:00:00");
        assertEquals(5,interDays);
    }

    @Test
    public void getIntervalDaysNumIsZerorTest() {
        int interDays = DateUtil.getIntervalDays("2015-08-10 00:00:00", "2015-08-21 00:00:00");
        assertEquals(-1,interDays);
    }

    @Test
    public void getIntervalDaysNumBadeFormatDateTest() {
        int interDays = DateUtil.getIntervalDays("2015-08-23 00:00:00", "2015-08-22 00:00:00");
        assertEquals(1,interDays);
    }

    @Test
    public void getIntervalDaysWithNullDateStrTest() {
        String date1 = null;
        String date2 = null;
        int interDays = DateUtil.getIntervalDays(date1, date2);
        assertEquals(-1,interDays);
    }

    @Test
    public void getIntervalDaysCompareDateTest() {
        int interDays = DateUtil.getIntervalDays(new Date(), new Date());
        assertEquals(0,interDays);
    }

    @Test
    public void getIntervalDaysWithNullDateTest() {
        Date date1 = null;
        Date date2 = null;
        int interDays = DateUtil.getIntervalDays(date1, date2);
        assertEquals(-1,interDays);
    }

}
