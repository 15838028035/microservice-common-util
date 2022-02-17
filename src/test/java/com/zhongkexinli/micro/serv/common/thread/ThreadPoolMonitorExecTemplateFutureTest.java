package com.zhongkexinli.micro.serv.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

public class ThreadPoolMonitorExecTemplateFutureTest {

    @Test
    public void test() {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
        
        List list = new ArrayList<>();
        
        list.add("testaa");
        
        ThreadPoolMonitorExecTemplateFutureTestA threadPoolMonitorExecTemplateFutureTestA = new ThreadPoolMonitorExecTemplateFutureTestA(executorService, list);
        
        threadPoolMonitorExecTemplateFutureTestA.execute();
    }

    
    class ThreadPoolMonitorExecTemplateFutureTestA extends ThreadPoolMonitorExecTemplateFuture {

        public ThreadPoolMonitorExecTemplateFutureTestA(ThreadPoolExecutor threadPoolExecutor, List list) {
            super(threadPoolExecutor, list);
        }

        @Override
        public void doExecute(Object t) throws Exception {
            System.out.println("testAA");
        }

        @Override
        public String getBuinsessName() {
            return "订单管理";
        }
        
    }
}
