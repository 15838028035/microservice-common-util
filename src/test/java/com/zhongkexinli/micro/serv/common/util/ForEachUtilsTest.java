package com.zhongkexinli.micro.serv.common.util;

import org.junit.Test;

public class ForEachUtilsTest {

    @Test
    public void foreachTest() {
        
        int forSize = 10;
        ForEachUtils.foreach( a -> {
           System.out.println("do aaa:"+a);
           return forSize;
        });
    }

}
