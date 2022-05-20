package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolMonitorTest {

    @Test
    public void test() throws InterruptedException {
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
          
          for(int i=0;i<10;i++) {
              executorService.execute(new RunA());
          }
          
          Thread.sleep(5000L);
    }
    
    
    class RunA implements Runnable {

        Logger logger = LoggerFactory.getLogger(RunA.class);
        
        @Override
        public void run() {
            logger.info("run aaa");
        }
        
    }

}
