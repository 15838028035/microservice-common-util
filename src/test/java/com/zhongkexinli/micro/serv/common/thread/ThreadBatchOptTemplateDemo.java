package com.zhongkexinli.micro.serv.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public   class ThreadBatchOptTemplateDemo  extends ThreadBatchOptTemplate<TestA>{

        @Override
        public void processBatch(CountDownLatch latch, List batchDataList) {
            for (Object   obj : batchDataList) {
                TestA testA = (TestA) obj;
                Runnable task = new processBatchDemo(latch,testA);
                executorService.submit(task);
            }
        }
        
        @Test
        public void test1() {
            List<TestA> testAList = new ArrayList<>();
            
            for(int i=0;i<5;i++) {
                TestA testA = new TestA();
                testA.setName("testA"+i);
                testAList.add(testA);
            }
            new ThreadBatchOptTemplateDemo().setBatchOptCount(10).setSleepTime(2000).startBatch(testAList);
        }
        
        @Test
        public void test2() {
            List<TestA> testAList = new ArrayList<>();
            
            for(int i=0;i<10;i++) {
                TestA testA = new TestA();
                testA.setName("testA"+i);
                testAList.add(testA);
            }
            
            new ThreadBatchOptTemplateDemo().setBatchOptCount(5).setSleepTime(2000).startBatch(testAList);
        }
        
     }