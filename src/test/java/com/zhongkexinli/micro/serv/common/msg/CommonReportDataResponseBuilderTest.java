package com.zhongkexinli.micro.serv.common.msg;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class CommonReportDataResponseBuilderTest {

    @Test
    public void builder1Test() {
        CommonReportDataResponse commonReportDataResponse =  new CommonReportDataResponseBuilder().code("1").msg("查询成功").count(100L).headers(Arrays.asList("header1","header2")).builder();
        Assert.assertEquals("1",commonReportDataResponse.getCode());
        Assert.assertEquals("查询成功",commonReportDataResponse.getMsg());
        Assert.assertEquals(2,commonReportDataResponse.getHeaders().size());
    }

}
