package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolMonitorTest {

    @Test
    public void test() {
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
          executorService.execute(new RunA());
    }
    
    
    class RunA implements Runnable {

        Logger logger = LoggerFactory.getLogger(RunA.class);
        
        @Override
        public void run() {
            logger.info("run aaa");
        }
        
    }

}
