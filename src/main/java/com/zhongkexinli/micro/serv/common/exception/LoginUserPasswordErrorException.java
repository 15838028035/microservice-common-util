package com.zhongkexinli.micro.serv.common.exception;

/**
 * 
 * 登陆密码错误异常
 *
 */
@SuppressWarnings("serial")
public class LoginUserPasswordErrorException extends CoreBaseRunTimeException {

    public LoginUserPasswordErrorException() {
        super();
    }

    public LoginUserPasswordErrorException(String message) {
        super(message);
    }

    public LoginUserPasswordErrorException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public LoginUserPasswordErrorException(Throwable rootCause) {
        super(rootCause);
    }
}
