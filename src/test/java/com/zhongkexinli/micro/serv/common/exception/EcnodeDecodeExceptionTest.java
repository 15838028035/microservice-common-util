package com.zhongkexinli.micro.serv.common.exception;

import org.junit.Test;

public class EcnodeDecodeExceptionTest {

  @Test(expected = EcnodeDecodeException.class)
  public void ecnodeDecodeExceptionTest() throws Exception{
    throw new EcnodeDecodeException();
  }

  @Test(expected = EcnodeDecodeException.class)
  public void ecnodeDecodeExceptionTest2() throws Exception{
    throw new EcnodeDecodeException("ecnodeDecodeException");
  }

  @Test(expected = EcnodeDecodeException.class)
  public void ecnodeDecodeExceptionThrowTest()  throws Exception{
    Throwable cause = new Throwable();
    throw new EcnodeDecodeException(cause);
  }

  @Test(expected = EcnodeDecodeException.class)
  public void ecnodeDecodeExceptionThrowMsgTest() throws Exception{
    Throwable cause = new Throwable();
    throw new EcnodeDecodeException("ecnodeDecodeException",cause);
  }
}
