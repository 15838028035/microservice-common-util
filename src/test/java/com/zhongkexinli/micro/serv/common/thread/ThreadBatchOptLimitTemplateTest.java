package com.zhongkexinli.micro.serv.common.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadBatchOptLimitTemplateTest extends ThreadBatchOptLimitTemplate<TestA>{


    @Override
    public void doRun(TestA testA) {
        /**
         * 操作处理t 对象，按需处理业务逻辑
         */
        System.out.println(testA.getName());
    }

    public static void main(String args[]) {
        ThreadBatchOptLimitTemplateTest threadBatchOptTemplateDemo = new ThreadBatchOptLimitTemplateTest();
        threadBatchOptTemplateDemo.setBatchOptCount(1000);
        threadBatchOptTemplateDemo.setSleepTime(3000);
     
        List<TestA> testAList = new ArrayList<>();
        
        for(int i=0;i<10;i++) {
            TestA testA = new TestA();
            testA.setName("testA"+i);
            testAList.add(testA);
        }
      
        threadBatchOptTemplateDemo.startBatch(testAList);
    }

}
