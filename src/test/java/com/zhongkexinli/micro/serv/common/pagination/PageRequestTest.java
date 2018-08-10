package com.zhongkexinli.micro.serv.common.pagination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PageRequestTest {

	private PageRequest pageRequest;
	
	@Before
	public void setUp() {
		pageRequest = new PageRequest();
	}
	
	@Test
	public void PageRequestTTest() {
		Filters Filters = new Filters();
		pageRequest = new PageRequest(Filters);
		assertEquals(0,pageRequest.getPageNumber());
		assertEquals(0,pageRequest.getPageSize());
		assertEquals("com.zhongkexinli.micro.serv.common.pagination.PageRequestTest$Filters",pageRequest.getFilters().getClass().getName());
	}

	@Test
	public void pageRequestPagNoPageSizeFilterTest() {
		pageRequest = new PageRequest(10,5);
		assertEquals(10,pageRequest.getPageNumber());
		assertEquals(5,pageRequest.getPageSize());
	}

	@Test
	public void pageRequestPageNoPageSizdeFilterTest() {
		Filters Filters = new Filters();
		pageRequest = new PageRequest(10,5,Filters);
		assertEquals(10,pageRequest.getPageNumber());
		assertEquals(5,pageRequest.getPageSize());
		assertEquals("com.zhongkexinli.micro.serv.common.pagination.PageRequestTest$Filters",pageRequest.getFilters().getClass().getName());
	}

	@Test
	public void pageRequestPageNoPageSizeSortColumnTest() {
		pageRequest = new PageRequest(10,5,"sortColumn");
		assertEquals(10,pageRequest.getPageNumber());
		assertEquals(5,pageRequest.getPageSize());
		assertEquals("sortColumn",pageRequest.getSortColumns());
	}

	@Test
	public void pageRequestPageNoPageSizeFilterSortColumnTest() {
		Filters Filters = new Filters();
		pageRequest = new PageRequest(10,5,Filters,"sortColumn");
		assertEquals(10,pageRequest.getPageNumber());
		assertEquals(5,pageRequest.getPageSize());
		assertEquals("com.zhongkexinli.micro.serv.common.pagination.PageRequestTest$Filters",pageRequest.getFilters().getClass().getName());
		assertEquals("sortColumn",pageRequest.getSortColumns());
	}

	@Test
	public void setGetFilters() {
		Filters filters = new Filters();
		pageRequest.setFilters(filters);
		assertEquals("com.zhongkexinli.micro.serv.common.pagination.PageRequestTest$Filters",pageRequest.getFilters().getClass().getName());
	}

	@Test
	public void setGetPageNumberTest() {
		pageRequest.setPageNumber(10);
		assertEquals(10,pageRequest.getPageNumber());
	}

	@Test
	public void setGetPageSize() {
		pageRequest.setPageSize(10);
		assertEquals(10,pageRequest.getPageSize());
	}

	@Test
	public void setGetSortColumnsTest() {
		pageRequest.setSortColumns("sortColumn");
		assertEquals("sortColumn",pageRequest.getSortColumns());
	}

	@Test
	public void getSortInfosTset() {
		pageRequest.setSortColumns("sortColumn");
		 List<SortInfo> sortInfoList = pageRequest.getSortInfos();
		 assertNotNull(sortInfoList);
	}

	private class Filters{
		
	}
}
