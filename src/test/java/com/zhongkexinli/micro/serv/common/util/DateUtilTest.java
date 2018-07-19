package com.zhongkexinli.micro.serv.common.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void getNowDateYYYYMMddHHMMSSTest() {
		String date = DateUtil.getNowDateYYYYMMddHHMMSS();
		assertTrue(date.length()==19);
	}

	@Test
	public void getNowDateTest() {
		String date = DateUtil.getNowDate("yyyy-MM-dd");
		assertTrue(date.length()==10);
	}

	@Test
	public void formatDateTest() {
		assertEquals("2015-10-01",(DateUtil.formatDate(DateUtil.formatDate("2015-10-01", "yyyy-MM-dd"), "yyyy-MM-dd")));
		assertEquals("2015-10-01 00:00:00",(DateUtil.formatDate(DateUtil.formatDate("2015-10-01", "yyyy-MM-dd"), "yyyy-MM-dd HH:mm:ss")));
		assertEquals("00:00:00",(DateUtil.formatDate(DateUtil.formatDate("2015-10-01", "yyyy-MM-dd"), "HH:mm:ss")));
		
		assertEquals(null,(DateUtil.formatDate(DateUtil.formatDate("2015-10-01", "yyyy-MM-dd"), "bad format")));
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
	
	@Test(expected = IllegalArgumentException.class)
	public void formatDateDateExceptionTest() {
		assertNull(DateUtil.formatDate("2015-10-01 10:00:00", "bad format"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void formatDateDateWidthBadFormatTest() {
		Date date = DateUtil.formatDate("2015-10-01 10:00:00", "yyyy-MM-dd gg ff");
		assertNull(date);
	}
	
	@Test
	public void getIntervalDaysTest(){
		int interDays = DateUtil.getIntervalDays("2015-08-10 00:00:00", "2015-08-05 00:00:00");
		assertTrue(interDays==5);
	}
	
	@Test
	public void getIntervalDaysNumIsZerorTest(){
		int interDays = DateUtil.getIntervalDays("2015-08-10 00:00:00", "2015-08-20 00:00:00");
		assertTrue(interDays==-10);
	}
	
	@Test
	public void getIntervalDaysNumBadeFormatDateTest(){
		int interDays = DateUtil.getIntervalDays("2015-08-20 00:00:00", "2015-08-20 00:00:00");
		assertTrue(interDays==0);
	}
	
	@Test
	public void getIntervalDaysWithNullDateStrTest(){
		String date1 = null;
		String date2 = null;
		int interDays = DateUtil.getIntervalDays(date1, date2);
		assertTrue(interDays==-1);
	}
	
	@Test
	public void getIntervalDaysCompareDateTest(){
		int interDays = DateUtil.getIntervalDays(new Date(), new Date());
		assertTrue(interDays==0);
	}
	
	@Test
	public void getIntervalDaysWithNullDateTest(){
		Date date1 = null;
		Date date2 = null;
		int interDays = DateUtil.getIntervalDays(date1,date2);
		assertTrue(interDays==-1);
	}

}
