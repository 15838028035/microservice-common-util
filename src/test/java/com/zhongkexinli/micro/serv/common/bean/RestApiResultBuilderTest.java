package com.zhongkexinli.micro.serv.common.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RestApiResultBuilderTest {
  @Test
  public void restApiResultBuilder1() {
    RestApiResult2 restApiResult = new RestApiResultBuilder()
             .respCode(1)
             .respData("cc")
             .respMsg("okay")
             .build();
      assertTrue(restApiResult.getRespCode() == 1);
      assertEquals("okay",restApiResult.getRespMsg());
      System.out.println(restApiResult.toString());
  }

}
