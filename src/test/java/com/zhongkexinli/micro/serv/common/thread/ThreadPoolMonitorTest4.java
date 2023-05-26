package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;

public class ThreadPoolMonitorTest4 {

    public static void main(String []args) {
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
          for(int i=0;i<10;i++) {
              executorService.execute(new RunA());
          }
    }
}
