package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;

import org.junit.Test;

public class ThreadPoolMonitorTest3 {

    @Test
    public void test() {
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
          for(int i=0;i<10;i++) {
              executorService.execute(new RunA());
          }
    }
    
    
    class RunA implements Runnable {
        
        @Override
        public void run() {
            System.out.println("run a");
            String a = null;
            a.length();
                    
        }
        
    }

}
