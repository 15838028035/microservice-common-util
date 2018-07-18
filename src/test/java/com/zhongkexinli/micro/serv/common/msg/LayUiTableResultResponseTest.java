package com.zhongkexinli.micro.serv.common.msg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhongkexinli.micro.serv.common.base.entity.BaseEntity;

public class LayUiTableResultResponseTest {

	@Test
	public void LayUiTableResultResponseTest1() {
		List<BaseEntity> dataList = new ArrayList<BaseEntity>();
		BaseEntity baseEntity = new BaseEntity();
		for(int i=0;i<100;i++) {
			
			baseEntity = new BaseEntity();
			baseEntity.setCreateBy(i);
			dataList.add(baseEntity);
			
		}
		
		LayUiTableResultResponse layUiTableResultResponse = new LayUiTableResultResponse<BaseEntity>(100L, dataList);
		
		assertTrue(layUiTableResultResponse!=null);
		assertEquals("0",layUiTableResultResponse.getCode());
		assertEquals("",layUiTableResultResponse.getMsg());
		assertTrue(layUiTableResultResponse.getCount()==100L);
		assertTrue(layUiTableResultResponse.getData().size()==100L);
	}
	
	@Test
	public void LayUiTableResultResponseTest2() {
		List<BaseEntity> dataList = new ArrayList<BaseEntity>();
		BaseEntity baseEntity = new BaseEntity();
		for(int i=0;i<100;i++) {
			
			baseEntity = new BaseEntity();
			baseEntity.setCreateBy(i);
			dataList.add(baseEntity);
			
		}
		
		LayUiTableResultResponse layUiTableResultResponse = new LayUiTableResultResponse<BaseEntity>("0","okay",100L, dataList);
		
		assertTrue(layUiTableResultResponse!=null);
		assertEquals("0",layUiTableResultResponse.getCode());
		assertEquals("okay",layUiTableResultResponse.getMsg());
		assertTrue(layUiTableResultResponse.getCount()==100L);
		assertTrue(layUiTableResultResponse.getData().size()==100L);
	}
	
	@Test
	public void LayUiTableResultResponseTest3() {
		List<BaseEntity> dataList = new ArrayList<BaseEntity>();
		BaseEntity baseEntity = new BaseEntity();
		for(int i=0;i<100;i++) {
			
			baseEntity = new BaseEntity();
			baseEntity.setCreateBy(i);
			dataList.add(baseEntity);
			
		}
		
		LayUiTableResultResponse layUiTableResultResponse = new LayUiTableResultResponse<BaseEntity>("0","okay",100L, dataList);
		
		layUiTableResultResponse.setCode("1");
		layUiTableResultResponse.setMsg("okayMsg");
		layUiTableResultResponse.setCount(200L);
		layUiTableResultResponse.setData(dataList);
		
		assertTrue(layUiTableResultResponse!=null);
		assertEquals("1",layUiTableResultResponse.getCode());
		assertEquals("okayMsg",layUiTableResultResponse.getMsg());
		assertTrue(layUiTableResultResponse.getCount()==200L);
		assertTrue(layUiTableResultResponse.getData().size()==100L);
	}

}
