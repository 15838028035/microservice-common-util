package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 设置过大的线程数量，任务执行完成时间，会变长，多个线程竞争，进行cpu进行上下文切换。
 *
 */
public class ThreadPoolMonitorTest5 {

    @Test 
    public void test1(){
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(8, "fileCopy"); 
          for(int i=0;i<1000;i++) {
              executorService.execute(new RunJiSuan2());
          }
          
          try {
            TimeUnit.MILLISECONDS.sleep(10000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Test 
    public void test2(){
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(100, "fileCopy"); 
          for(int i=0;i<1000;i++) {
              executorService.execute(new RunJiSuan2());
          }
          
          try {
              TimeUnit.MILLISECONDS.sleep(10000L);
          } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
    }
    
    @Test 
    public void test3(){
          ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(1, "fileCopy"); 
          for(int i=0;i<1000;i++) {
              executorService.execute(new RunJiSuan2());
          }
          
          try {
              TimeUnit.MILLISECONDS.sleep(10000L);
          } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
    }
}
