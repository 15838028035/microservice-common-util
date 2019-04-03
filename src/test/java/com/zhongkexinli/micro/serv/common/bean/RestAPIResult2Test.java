package com.zhongkexinli.micro.serv.common.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RestAPIResult2Test {

	@Test
	public void RestAPIResultTest4() {
	  RestAPIResult2 restAPIResult = new RestAPIResult2("okay");
		assertTrue(restAPIResult.getRespCode()==0);
		assertEquals("okay",restAPIResult.getRespMsg());
		
		
		restAPIResult.messageFormat("错误了,{0}", "真的错了");
		
		assertEquals("错误了,真的错了",restAPIResult.getRespMsg());
	}
	
	 @Test
	  public void RestAPIResultTest5() {
	    new RestAPIResult2().respCode(0)
	                        .respMsg("aa {0}", "bb")
	                        .respData("222");
	  }
	 
	 
	 @Test
	  public void RestAPIResultTest6() {
	    RestAPIResult2 restAPIResult = new RestAPIResult2("okay");
	    assertTrue(restAPIResult.getRespCode()==0);
	    assertEquals("okay",restAPIResult.getRespMsg());
	    
	    
	    restAPIResult.respMsg("错误了,{}", "真的错了");
	    
	    assertEquals("错误了,真的错了",restAPIResult.getRespMsg());
	  }
	 
	 @Test
	  public void RestAPIResultTest7() {
	    RestAPIResult2 restAPIResult = new RestAPIResult2("okay");
	    assertTrue(restAPIResult.getRespCode()==0);
	    assertEquals("okay",restAPIResult.getRespMsg());
	    
	    
	    restAPIResult.respMsg("错误了,{}A {}B {} C", "1", "2","3");
	    
	    assertEquals("错误了,1A 2B 3 C",restAPIResult.getRespMsg());
	  }
	 
	 @Test
   public void RestAPIResultTest8() {
     RestAPIResult2 restAPIResult = new RestAPIResult2("okay");
     assertTrue(restAPIResult.getRespCode()==0);
     assertEquals("okay",restAPIResult.getRespMsg());
     
     
     restAPIResult.respMsg("错误了,{0}", "1");
     
     assertEquals("错误了,{0}",restAPIResult.getRespMsg());
   }

}
