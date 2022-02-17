package com.zhongkexinli.micro.serv.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 线程池执行模板, 会等待所有任务执行完毕
 *
 */
public  abstract class ThreadPoolMonitorExecTemplateFuture<T> {
  
  private static Logger logger = LoggerFactory.getLogger(ThreadPoolMonitorExecTemplateFuture.class);
    
  private ThreadPoolExecutor threadPoolExecutor; 
    
  private   List<T> list;
  
  public ThreadPoolMonitorExecTemplateFuture(ThreadPoolExecutor threadPoolExecutor,  List<T> list) {
      this.threadPoolExecutor = threadPoolExecutor;
      this.list = list;
  }
  
  public List<Future>  execute() {
      
      long startTime = System.currentTimeMillis();
      
      logger.info(getBuinsessName()+"开始执行了");
      
      List<Future> futures = new ArrayList<>();
      
      for (T t : list) {
          
          /**
           * 给元素添加后缀
           */
          Future future =  threadPoolExecutor.submit(()-> {
              try {
                  doExecute(t);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          });
          futures.add(future);
    
      }
      
      for (Future future : futures) {
          try {
              future.get();
          } catch (InterruptedException e) {
              e.printStackTrace();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
    
      
      long endTime = System.currentTimeMillis();
      
      logger.info(getBuinsessName()+"执行结束了");
      
      logger.info(getBuinsessName()+"花费时间"+String.valueOf(endTime - startTime)+ "毫秒，"
              + "约:"+String.valueOf((endTime - startTime)/1000) +"秒, 约"+String.valueOf((endTime - startTime)/60000)+"分钟"  
               );
      
      return futures;
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
