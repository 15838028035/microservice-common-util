package com.zhongkexinli.micro.serv.common.thread;


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程批量操作限流工具类
 * 
 */
public abstract class ThreadBatchOptTemplate<T> {
    
    protected static Logger logger = LoggerFactory.getLogger(ThreadBatchOptTemplate.class);

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
    public static  final  ExecutorService executorService = ThreadPoolMonitor.threadPoolMonitor(Runtime.getRuntime().availableProcessors(), "threadBatchOptTemplate");
    
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
            
            LocalDateTime startTime = LocalDateTime.now();
            
            int size = batchDataList.size();
            int pageNum = getPageNum(size);
            
            logger.info("需要处理的任务数量:{}", batchDataList.size());
            
            for (int index = 0; index < pageNum; index++) {
                int start = index * batchOptCount;
                int last = getLastNum(size, start + batchOptCount);

                final CountDownLatch latch = new CountDownLatch(last - start);
                // 获取列表子集
                List list = batchDataList.subList(start, last);
                processBatch(latch,list);
                latch.await();
                
                logger.info("开始尝试sleep:{}毫秒", sleepTime);
                Thread.sleep(sleepTime);
            }
            
            LocalDateTime finishDate = LocalDateTime.now();
            
            java.time.Duration duration = java.time.Duration.between(startTime, finishDate);
            
            logger.info("需要处理的任务耗费时间统计:{}毫秒, 合计约:{}秒,合计约:{}分钟", duration.toMillis(),duration.getSeconds(),duration.toMinutes());
            
        } catch (Exception e) {
            logger.error("批量处理出现异常", e);
        }
        logger.info("批量处理线程处理完毕");
    }
   
    /**
     * 获取最后一个元素
     *
     * @param size  列表长度
     * @param index 下标
     * @return int
     */
    private static int getLastNum(int size, int index) {
        return index > size ? size : index;
    }

    /**
     * 获取划分页面数量
     *
     * @param size 列表长度
     * @return int
     */
    private  int getPageNum(int size) {
        int tmp = size / batchOptCount;
        return size % batchOptCount == 0 ? tmp : tmp + 1;
    }

    public int getBatchOptCount() {
        return batchOptCount;
    }

    public ThreadBatchOptTemplate<T> setBatchOptCount(int batchOptCount) {
        this.batchOptCount = batchOptCount;
        return this;
    }
    
    public long getSleepTime() {
        return sleepTime;
    }

    public ThreadBatchOptTemplate<T> setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }
    
    /**
     * 抽象类，按需实现
     * @param batchDataList
     */
    public abstract   void processBatch(CountDownLatch latch,List<T> batchDataList ) ;
        /**
        for (Object obj : batchDataList) {
            // 提交任务
            Runnable task = new processBatchDemo(latch);
            executorService.submit(task);
        }
        }
        */
  
}