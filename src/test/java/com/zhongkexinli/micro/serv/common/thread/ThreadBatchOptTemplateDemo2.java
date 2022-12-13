package com.zhongkexinli.micro.serv.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public   class ThreadBatchOptTemplateDemo2  extends ThreadBatchOptTemplate<TestA>{

        @Override
        public void processBatch(CountDownLatch latch, List batchDataList) {
            for (Object   obj : batchDataList) {
                TestA testA = (TestA) obj;
                Runnable task = new processBatchDemo(latch,testA);
                executorService.submit(task);
            }
        }
        
        public static void main(String args[]) {
        	
        	for(int j=0; j<5;j++) {
        		 ThreadBatchOptTemplateDemo2 threadBatchOptTemplateDemo = new ThreadBatchOptTemplateDemo2();
                 threadBatchOptTemplateDemo.setBatchOptCount(20);
                 threadBatchOptTemplateDemo.setSleepTime(1000);
              
                 List<TestA> testAList = new ArrayList<>();
                 
                 for(int i=0;i<10;i++) {	
                     TestA testA = new TestA();
                     testA.setName("testA"+i);
                     testAList.add(testA);
                 }
               
                 threadBatchOptTemplateDemo.startBatch(testAList);
        	}
           
        }
     }