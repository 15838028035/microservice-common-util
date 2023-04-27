package com.zhongkexinli.micro.serv.common.msg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhongkexinli.micro.serv.common.base.entity.BaseEntity;


/**
 * 
 * layui分页相应信息
 *
 * PO对象
 */
public class LayUiTableResultResponseTest {

    @Test
    @SuppressWarnings("all")
    public void layUiTableResultResponseTest1() {
        List<BaseEntity> dataList = new ArrayList<>();
        BaseEntity baseEntity = new BaseEntity();
        for (int i = 0; i < 100; i++) {
            baseEntity.setCreateBy(i);
            dataList.add(baseEntity);

        }

        LayUiTableResultResponse layUiTableResultResponse = new LayUiTableResultResponse(100L, dataList);

        assertNotNull(layUiTableResultResponse);
        assertEquals("0", layUiTableResultResponse.getCode());
        assertEquals("", layUiTableResultResponse.getMsg());
        assertEquals(100,layUiTableResultResponse.getCount().intValue());
        assertEquals(100,layUiTableResultResponse.getData().size());
    }

    @Test
    public void layUiTableResultResponseTest2() {
        List<BaseEntity> dataList = new ArrayList<>();
        BaseEntity baseEntity = new BaseEntity();
        for (int i = 0; i < 100; i++) {
            baseEntity.setCreateBy(i);
            dataList.add(baseEntity);

        }

        LayUiTableResultResponse layUiTableResultResponse = new LayUiTableResultResponse("0", "okay", 100L, dataList);

        assertNotNull(layUiTableResultResponse);
        assertEquals("0", layUiTableResultResponse.getCode());
        assertEquals("okay", layUiTableResultResponse.getMsg());
        assertEquals(100,layUiTableResultResponse.getCount().intValue());
        assertEquals(100,layUiTableResultResponse.getData().size());
    }

    @Test
    public void layUiTableResultResponseTest3() {
        List<BaseEntity> dataList = new ArrayList<>();
        BaseEntity baseEntity = new BaseEntity();
        for (int i = 0; i < 100; i++) {
            baseEntity.setCreateBy(i);
            dataList.add(baseEntity);

        }

        LayUiTableResultResponse layUiTableResultResponse = new LayUiTableResultResponse("0", "okay", 100L, dataList);

        layUiTableResultResponse.setCode("1");
        layUiTableResultResponse.setMsg("okayMsg");
        layUiTableResultResponse.setCount(200L);
        layUiTableResultResponse.setData(dataList);

        assertNotNull(layUiTableResultResponse);
        assertEquals("1", layUiTableResultResponse.getCode());
        assertEquals("okayMsg", layUiTableResultResponse.getMsg());
        assertEquals(200,layUiTableResultResponse.getCount().intValue());
        assertEquals(100,layUiTableResultResponse.getData().size());
    }

}
