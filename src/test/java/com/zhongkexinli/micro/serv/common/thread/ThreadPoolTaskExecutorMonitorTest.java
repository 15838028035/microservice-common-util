package com.zhongkexinli.micro.serv.common.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolTaskExecutorMonitorTest {

    @Test
    public void test() throws InterruptedException {
        ThreadPoolTaskExecutorMonitor executorService = ThreadPoolTaskExecutorMonitor.threadPoolTaskExecutorMonitor(5,5,1000L,1000,"tesa"); 
          
        executorService.initialize();
        
          for(int i=0;i<10;i++) {
              executorService.execute(new RunA());
          }
          
          Thread.sleep(10000L);
    }
    
    
    class RunA implements Runnable {

        Logger logger = LoggerFactory.getLogger(RunA.class);
        
        @Override
        public void run() {
            logger.info("run aaa");
        }
        
    }

}
