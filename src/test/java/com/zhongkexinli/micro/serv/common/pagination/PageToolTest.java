package com.zhongkexinli.micro.serv.common.pagination;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 分页工具类
 *
 */
public class PageToolTest {

    @Before
    public void setUp() {
        new PageTool();
    }

    @Test
    public void pageToJsonLayuiTest() {
        List<TestClass1> testClass1 = new ArrayList<>();

        Page page = new Page(20);
        page.setPageNumber(10);
        page.setPageSize(100);
        page.setPageNumber(1);
        page.setTotalCount(100);
        page.setResult(testClass1);

        String result = PageTool.pageToJsonLayui(page);
        assertEquals("{\"total\":100,\"pageNumber\":1,\"totalPage\":1,\"pageSize\":100,\"page\":1,\"rows\":[]}",
                result);

    }

    private class TestClass1 {

    }
}
