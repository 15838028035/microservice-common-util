package com.zhongkexinli.micro.serv.common.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RestAPIResult2Test {

    @Test
    public void restApiResultTest4() {
        RestApiResult2 restApiResult = new RestApiResult2("okay");
        assertTrue(restApiResult.getRespCode() == 0);
        assertEquals("okay",restApiResult.getRespMsg());
    }
    
    @Test
     public void restApiResultTest5() {
        new RestApiResult2().respCode(0)
                            .respMsg("aa {0}", "bb")
                          .respData("222");
    }
     
    @Test
    public void restApiResultTest6() {
     RestApiResult2 restAPIResult = new RestApiResult2("okay");
    assertTrue(restAPIResult.getRespCode()==0);
    assertEquals("okay",restAPIResult.getRespMsg());
    
    
    restAPIResult.respMsg("错误了,{}", "真的错了");
    
    assertEquals("错误了,真的错了",restAPIResult.getRespMsg());
    }
   
   @Test
    public void restApiResultTest7() {
      RestApiResult2 restAPIResult = new RestApiResult2("okay");
    assertTrue(restAPIResult.getRespCode()==0);
    assertEquals("okay",restAPIResult.getRespMsg());
    
    
    restAPIResult.respMsg("错误了,{}A {}B {} C", "1", "2","3");
    
    assertEquals("错误了,1A 2B 3 C",restAPIResult.getRespMsg());
  }
	 
	 @Test
   public void restApiResultTest8() {
     RestApiResult2 restAPIResult = new RestApiResult2("okay");
     assertTrue(restAPIResult.getRespCode()==0);
     assertEquals("okay",restAPIResult.getRespMsg());
     
     
     restAPIResult.respMsg("错误了,{0}", "1");
     
     assertEquals("错误了,{0}",restAPIResult.getRespMsg());
   }

}
