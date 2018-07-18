package com.zhongkexinli.micro.serv.common.base.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BaseEntityTest {

	private BaseEntity baseModel;
	
	@Before
	public void setUp() {
		baseModel = new BaseEntity();
	}

	@Test
	public void setGetCreateByTest() {
		baseModel.setCreateBy(1);
		assertEquals("CreateBy must be 1","1", baseModel.getCreateBy().toString());
	}

	@Test
	public void setGetCreateDateTest() {
		baseModel.setCreateDate("2015-10-01 10:00:00");
		assertEquals("CreateDate must be 2015-10-01 10:00:00","2015-10-01 10:00:00", baseModel.getCreateDate());
	}

	@Test
	public void setGetUpdateByTest() {
		baseModel.setUpdateBy(2);
		assertEquals("UpdateBy must be 2","2", baseModel.getUpdateBy().toString());
	}

	@Test
	public void setGetUpdateDateTest() {
		baseModel.setUpdateDate("2015-10-01 11:00:00");
		assertEquals("UpdateDate must be 2015-10-01 11:00:00","2015-10-01 11:00:00", baseModel.getUpdateDate());
	}

	@Test
	public void setGetEnableFlagTest() {
		baseModel.setEnableFlag("T");
		assertEquals("EnableFlag must be T","T", baseModel.getEnableFlag());
	}

	@Test
	public void setGetLockStatusTest() {
		baseModel.setLockStatus("0");
		assertEquals("LockStatus must be 0","0", baseModel.getLockStatus());
	}
	
	@Test
	public void setSidxTest() {
		baseModel.setSidx("sidx");
		assertEquals("sidx must be sidx","sidx", baseModel.getSidx());
	}
	
	@Test
	public void setSordTest() {
		baseModel.setSord("sord");
		assertEquals("sord must be sord","sord", baseModel.getSord());
	}
	
	@Test
	public void toStringTest() {
		System.out.println(baseModel);
	}

}
