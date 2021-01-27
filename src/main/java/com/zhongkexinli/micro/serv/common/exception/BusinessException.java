package com.zhongkexinli.micro.serv.common.exception;

/**
 * 
 * 业务逻辑异常
 *
 */
@SuppressWarnings("serial")
public class BusinessException extends CoreBaseRunTimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
