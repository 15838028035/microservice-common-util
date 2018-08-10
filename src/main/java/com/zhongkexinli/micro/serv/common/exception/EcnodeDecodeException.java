package com.zhongkexinli.micro.serv.common.exception;

/**
 * 
 * 告警异常
 *
 */
@SuppressWarnings("serial")
public class EcnodeDecodeException extends CoreBaseRunTimeException {

  public EcnodeDecodeException() {
    super();
  }

  public EcnodeDecodeException(String message) {
    super(message);
  }

  public EcnodeDecodeException(Throwable cause) {
    super(cause);
  }

  public EcnodeDecodeException(String message, Throwable cause) {
    super(message, cause);
  }

}
