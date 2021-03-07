package com.zhongkexinli.micro.serv.common.bean;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RestApiResultBuilderTest {
  @Test
  public void restApiResultBuilder1() {
    RestApiResult2 restApiResult = new RestApiResultBuilder()
             .respCode(1)
             .respData("cc")
             .respMsg("okay")
             .build();
    assertEquals(1,restApiResult.getRespCode());
      assertEquals("okay",restApiResult.getRespMsg());
      System.out.println(restApiResult.toString());
  }

}
