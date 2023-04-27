package com.zhongkexinli.micro.serv.common.thread;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程批量操作限流工具类
 * 
 */
public abstract  class ThreadBatchOptLimitTemplate<T> {
    
    protected static Logger logger = LoggerFactory.getLogger(ThreadBatchOptLimitTemplate.class);

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
   private  final  Semaphore semaphore = new Semaphore(getBatchOptCount());
   
   public static AtomicInteger currentNo = new AtomicInteger(0);
   
    /**
     * 线程池监控，是否完成
     * @return
     */
    public static boolean isExecuteEnd() {
        ThreadPoolExecutor tpe = ((ThreadPoolExecutor) executorService);
        
    	int queueSize = tpe.getQueue().size();
    	// logger.info("当前排队线程数：{}" , queueSize);
 
        int activeCount = tpe.getActiveCount();
       // logger.info("当前活动线程数：{}" , activeCount);
 
        long completedTaskCount = tpe.getCompletedTaskCount();
      //  logger.info("执行完成线程数：{}" , completedTaskCount);
 
        long taskCount = tpe.getTaskCount();
      //  logger.info("总线程数：{}" , taskCount);
        
        return  taskCount == completedTaskCount;
    }
    
    /**
     * 定时监控线程池是否执行完毕
     */
    public static void monitor() {
        while (!ThreadBatchOptLimitTemplate.isExecuteEnd()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("线程Sleep出现异常", e);
            }

        }
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

    public ThreadBatchOptLimitTemplate<T> setBatchOptCount(int batchOptCount) {
        this.batchOptCount = batchOptCount;
        return this;
    }
    
    public long getSleepTime() {
        return sleepTime;
    }

    public ThreadBatchOptLimitTemplate<T> setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }
    
    /**
     * 抽象类，按需实现
     * @param batchDataList
     */
    public    void processBatch(List<T> batchDataList ) {
        for (Object obj : batchDataList) {
            executorService.execute(() -> {
                try {
                    
                    //阻塞，获取令牌
                   semaphore.acquire();
                   
                   int a=  currentNo.incrementAndGet();
                   
                   if(a> batchOptCount) {
                       currentNo = new AtomicInteger(0);
                       
                       logger.info("开始尝试sleep:{}毫秒", sleepTime);
                       TimeUnit.MILLISECONDS.sleep(sleepTime);
                   }
                   
                   doRun((T)obj) ;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    logger.error("批量操作出现异常",e);
              } catch (Exception e) {
                  logger.error("批量操作出现异常",e);
              }finally {
                 semaphore.release();
            }
            });
        }
}
       
   public abstract void doRun( T t) ;
  
}