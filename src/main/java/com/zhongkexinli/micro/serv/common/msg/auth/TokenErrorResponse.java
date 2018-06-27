package com.zhongkexinli.micro.serv.common.msg.auth;

import com.zhongkexinli.micro.serv.common.constant.RestCodeConstants;
import com.zhongkexinli.micro.serv.common.msg.BaseResponse;

public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
