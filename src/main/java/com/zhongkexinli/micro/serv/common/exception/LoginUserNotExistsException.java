package com.zhongkexinli.micro.serv.common.exception;

/**
 * 
 * 登陆用户不存在异常
 *
 */
@SuppressWarnings("serial")
public class LoginUserNotExistsException extends CoreBaseRunTimeException {

  public LoginUserNotExistsException() {
    super();
  }

  public LoginUserNotExistsException(String message) {
    super(message);
  }

  public LoginUserNotExistsException(String message, Throwable rootCause) {
    super(message, rootCause);
  }

  public LoginUserNotExistsException(Throwable rootCause) {
    super(rootCause);
  }
}
