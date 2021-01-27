package com.zhongkexinli.micro.serv.common.exception;

/**
 * 
 * 告警异常
 *
 */
@SuppressWarnings("serial")
public class WarnException extends CoreBaseRunTimeException {

    public WarnException() {
        super();
    }

    public WarnException(String message) {
        super(message);
    }

    public WarnException(Throwable cause) {
        super(cause);
    }

    public WarnException(String message, Throwable cause) {
        super(message, cause);
    }

}
