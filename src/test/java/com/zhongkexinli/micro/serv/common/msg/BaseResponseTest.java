package com.zhongkexinli.micro.serv.common.msg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 基础异常
 *
 */
public class BaseResponseTest {
    @Test
    public void baseResponseTest1() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(200);
        baseResponse.setMessage("okay");
        assertEquals(200, baseResponse.getStatus());
        assertEquals("okay", baseResponse.getMessage());
    }

    @Test
    public void baseResponseTest2() {
        BaseResponse baseResponse = new BaseResponse(200, "okay");
        assertEquals(200,baseResponse.getStatus());
        assertEquals("okay", baseResponse.getMessage());
    }

}
