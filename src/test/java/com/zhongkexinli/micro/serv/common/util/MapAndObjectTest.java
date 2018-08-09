package com.zhongkexinli.micro.serv.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.zhongkexinli.micro.serv.common.base.entity.BaseEntity;

public class MapAndObjectTest {
	Map<Object,Object> map = new HashMap<>();
	BaseEntity baseEntity = new BaseEntity();
	
	@Before
	public void setUp() {
		map.put("java", "diy");
		map.put("roleId", "from map");
		map.put(123, 456);
		
		baseEntity.setCreateByUname("manager");
		baseEntity.setCreateBy(1);
	}
	
	@Test
	public void testWithNull() {
		MapAndObject m = new MapAndObject(null,null);
		assertEquals(null,m.get("1"));
		
		m = new MapAndObject(map,null);
		assertEquals("diy",m.get("java"));
		
		m = new MapAndObject(null,baseEntity);
		assertEquals("manager",m.get("createByUname"));
	}
	
	@Test
	public void test() {
		
		MapAndObject m = new MapAndObject(map,baseEntity);
		assertEquals("manager",m.get("createByUname"));
		
		map.put("createByUname", null);
		assertEquals(1 ,m.get("createBy"));
		
		baseEntity.setCreateBy(null);
		assertEquals(null ,m.get("createBy"));
		
		assertNull(m.get("9527name"));
		assertNull(m.get("notexistmethod"));
	}
	
	@Test
	public void testPerfoemance() {
		MapAndObject m = new MapAndObject(map,baseEntity);
		long start = System.currentTimeMillis();
		int count = 10000 * 10;
		for(int i = 0; i < count; i++) {
			String random = StringUtil.getRandomString(2);
			assertNull(m.get(random));
		}
		long cost = System.currentTimeMillis() - start;
		System.out.println("MapAndObject.get() costTime:"+cost+" per request cost:"+(cost/(float)count)+" count="+count);
		assertTrue("MapAndObject.get() costTime:234 per request cost:0.00234 count=100000",cost < 1000);
	}
	
	@Test
	public void testReadonly() {
		MapAndObject m = new MapAndObject(map,baseEntity);
		assertEquals(null,m.get("writeonly"));
	}
}
