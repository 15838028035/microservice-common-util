package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPoolMonitorTest1 {

    @Test
    public void test() throws InterruptedException {
        
        /**
         * 创建一个只有线程的线程池，该方法无参数，所有任务都保存队列LinkedBlockingQueue中，等待唯一的单线程来执行任务，并保证所有任务按照指定顺序(FIFO或优先级)执行。
         */
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(1, "fileCopy"); 
          
          for(int i=0;i<10;i++) {
              executorService.execute(new RunA(i));
          }
          
          Thread.sleep(5000L);
    }
    
    
    class RunA implements Runnable {

        Logger logger = LoggerFactory.getLogger(RunA.class);
        
        private int a ;
        
        public RunA(int a) {
            this.a = a;
        }
        
        @Override
        public void run() {
            logger.info("run aaa:{}",a);
        }
        
    }

}
