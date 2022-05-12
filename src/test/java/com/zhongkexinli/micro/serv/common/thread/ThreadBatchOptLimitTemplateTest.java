package com.zhongkexinli.micro.serv.common.thread;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class ThreadBatchOptLimitTemplateTest extends ThreadBatchOptLimitTemplate<TestA>{


    @Override
    public void doRun(TestA testA) {
        /**
         * 操作处理t 对象，按需处理业务逻辑
         */
        logger.info("test=={}",testA.getName());
    }

    @Test
    public void test1() throws InterruptedException {
        List<TestA> testAList = new ArrayList<>();
        
        for(int i=0;i<5;i++) {
            TestA testA = new TestA();
            testA.setName("testA"+i);
            testAList.add(testA);
        }
        new ThreadBatchOptLimitTemplateTest().setBatchOptCount(10).setSleepTime(2000).startBatch(testAList);
        
        Thread.sleep(5000L);
    }
    
    @Test
    @Ignore
    public void test2() throws InterruptedException {
        List<TestA> testAList = new ArrayList<>();
        
        for(int i=0;i<10;i++) {
            TestA testA = new TestA();
            testA.setName("testA"+i);
            testAList.add(testA);
        }
        
        new ThreadBatchOptLimitTemplateTest().setBatchOptCount(5).setSleepTime(2000).startBatch(testAList);
        
        Thread.sleep(5000L);
    }

}
