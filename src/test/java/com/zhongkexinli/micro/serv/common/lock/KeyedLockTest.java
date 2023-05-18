package com.zhongkexinli.micro.serv.common.lock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.zhongkexinli.micro.serv.common.thread.ThreadPoolMonitor;

public class KeyedLockTest {

    @Test
    public void test1() {
         final KeyedLock<String> connectionLock = new KeyedLock<>();
         
         String lockKey = "lockKey";
         
         try (Releasable ignored = connectionLock.acquire(lockKey)) {
             System.out.println("业务逻辑处理");
         } 
    }
    

    @Test
    public void test2() {
         final KeyedLock<String> connectionLock = new KeyedLock<>();
         
         String lockKey = "lockKey";
         
         ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(5, "fileCopy"); 
         for(int i=0;i<10;i++) {
             executorService.execute(()-> {
                 try (Releasable ignored = connectionLock.acquire(lockKey)) {
//                     System.out.println("业务逻辑处理");
                     TimeUnit.MILLISECONDS.sleep(1000L);
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                     String time = formatter.format(LocalDateTime.now());
                     System.out.println("time:"+time);
                 } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
             });
         }
         
         try {
             /**
              * 休息时间，一定要大于10秒
              */
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}
