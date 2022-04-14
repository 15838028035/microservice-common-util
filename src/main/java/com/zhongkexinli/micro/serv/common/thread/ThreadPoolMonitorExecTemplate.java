package com.zhongkexinli.micro.serv.common.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 线程池执行模板, 会等待所有任务执行完毕
 *
 */
public  abstract class ThreadPoolMonitorExecTemplate<T> {
  
  private static Logger logger = LoggerFactory.getLogger(ThreadPoolMonitorExecTemplate.class);
    
  private ThreadPoolExecutor threadPoolExecutor; 
    
  private   List<T> list;
  
  protected  ThreadPoolMonitorExecTemplate(ThreadPoolExecutor threadPoolExecutor,  List<T> list) {
      this.threadPoolExecutor = threadPoolExecutor;
      this.list = list;
  }
  
  public void execute() {
      
      long startTime = System.currentTimeMillis();
      
      logger.info("{} 开始执行了",getBuinsessName());
      
      CountDownLatch countDownLatch = new CountDownLatch(list.size());
      
      for (T t : list) {
          /**
           * 给元素添加后缀
           */
          threadPoolExecutor.execute(new Runnable() {
            
            @Override
            public void run() {
                try {
                    doExecute(t);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("多线程执行过程中出现异常",e);
                }finally {
                    countDownLatch.countDown();
                }
            }
        });
      }
      try {
          countDownLatch.await();
      } catch (InterruptedException e) {
          logger.error("线程出现异常",e);
      }
      
      long endTime = System.currentTimeMillis();
      
      logger.info("{} 执行结束了",getBuinsessName());
      
      logger.info(getBuinsessName()+"花费时间"+(endTime - startTime)+ "毫秒，"
              + "约:"+((endTime - startTime)/1000) +"秒, 约"+(endTime - startTime)/60000+"分钟"  
               );
  }

  /**
   * 抽象执行方法
   */
 public   abstract  void doExecute(T t) throws Exception ;
 
 /**
  * 业务名称
  */
 public  abstract   String  getBuinsessName() ;
    
}
