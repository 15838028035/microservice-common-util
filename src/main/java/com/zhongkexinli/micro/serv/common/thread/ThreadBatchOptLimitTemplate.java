package com.zhongkexinli.micro.serv.common.thread;


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程批量操作限流工具类
 * 
 */
public abstract  class ThreadBatchOptLimitTemplate<T> {
    
    private static Logger logger = LoggerFactory.getLogger(ThreadBatchOptLimitTemplate.class);

    /**
     * 默认1批量处理数量
     */
    private   int batchOptCount = 200;
    
    /**
     * 默认睡眠休息时间
     */
    private   long sleepTime = 2000L;

    /**
     * 线程池
     */
    public static  final  ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(Runtime.getRuntime().availableProcessors(), "threadBatchOptLimitTemplate");
    
    
    /**
     * 设置最多处理的机器数量, 默认按照最多10个进行设置
     */
   private   Semaphore semaphore = new Semaphore(getBatchOptCount());
   
   public static AtomicInteger currentNo = new AtomicInteger(0);
   
    /**
     * 线程池监控，是否完成
     * @return
     */
    public static boolean isExecuteEnd() {
        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) executorService);
        
    	int queueSize = tpe.getQueue().size();
    	logger.info("当前排队线程数：{}" , queueSize);
 
        int activeCount = tpe.getActiveCount();
        logger.info("当前活动线程数：{}" , activeCount);
 
        long completedTaskCount = tpe.getCompletedTaskCount();
        logger.info("执行完成线程数：{}" , completedTaskCount);
 
        long taskCount = tpe.getTaskCount();
        logger.info("总线程数：{}" , taskCount);
        
        return  taskCount == completedTaskCount;
    }

    /**
     * 开始批量处理
     */
    public  void startBatch(List batchDataList) {
        try {
            logger.info("需要处理的任务数量:{}", batchDataList.size());
            processBatch(batchDataList);
            logger.info("需要处理的任务已经提交，等待多线程处理,请耐心等待");
            
        } catch (Exception e) {
            logger.error("批量处理出现异常", e);
        }
        logger.info("批量处理线程处理完毕");
    }

    public int getBatchOptCount() {
        return batchOptCount;
    }

    public void setBatchOptCount(int batchOptCount) {
        this.batchOptCount = batchOptCount;
    }
    
    public long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }
    
    /**
     * 抽象类，按需实现
     * @param batchDataList
     */
    public    void processBatch(List<T> batchDataList ) {
        for (Object obj : batchDataList) {
            // 提交任务
            executorService.submit(() -> {
                try {
                    
                    //阻塞，获取令牌
                   semaphore.acquire();
                   
                   int a=  currentNo.incrementAndGet();
                   
                   if(a> batchOptCount) {
                       currentNo = new AtomicInteger(0);
                       
                       logger.info("开始尝试sleep:{}毫秒", sleepTime);
                       Thread.currentThread().sleep(sleepTime);
                   }
                   
                   doRun((T)obj) ;
                   
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }finally {
                 semaphore.release();
            }
            });
        }
}
       
   public abstract void doRun( T t) ;
  
}