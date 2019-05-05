package com.zhongkexinli.micro.serv.common.exception;

/**
 * 
 * 参数为空异常
 *
 */
@SuppressWarnings("serial")
public class ParameterNullException extends CoreBaseRunTimeException {

    public ParameterNullException() {
      super();
    }
  
    public ParameterNullException(String message) {
      super(message);
    }
  
    public ParameterNullException(String message, Throwable rootCause) {
      super(message, rootCause);
    }
  
    public ParameterNullException(Throwable rootCause) {
      super(rootCause);
    }
}
