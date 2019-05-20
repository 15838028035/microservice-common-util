package com.zhongkexinli.micro.serv.common.pagination;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * 查询参数
 */
public class QueryTest {

    @Test
    public void test() {
        Query query = new Query().putFilter("key", "1234").putFilter("key2", "45678");

        assertEquals("1234", query.get("key").toString());
        assertEquals("45678", query.get("key2").toString());
    }

}
