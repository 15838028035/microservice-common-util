package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;

import org.junit.Test;

public class ThreadPoolMonitorTest2 {

    @Test
    public void test() {
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
          
          for(int i=0;i<10;i++) {
        	  System.out.println(i);
        	  executorService.execute(new RunA());
          }
    }
    
    
    class RunA implements Runnable {
        
        @Override
        public void run() {
        	System.out.println("run aa");
            double random = (Math.random()*10);
            System.out.println(random);
            
			/*
			 * if(random>5) { throw new RuntimeException("运行时异常"); }
			 */
        }
        
    }

}
