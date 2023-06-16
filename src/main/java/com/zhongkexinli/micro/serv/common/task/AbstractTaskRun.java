package com.zhongkexinli.micro.serv.common.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zhongkexinli.micro.serv.common.util.StringUtil;

/**
 * 抽象定时任务执行类
 *
 */
public abstract class AbstractTaskRun {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    
    /**
     * 公共执行方法
     */
    public void run()  {
        
        logger.info("定时任务:{},开始执行", getTaskName());
        long startTime = System.currentTimeMillis();
        
        try {
            
            if(StringUtil.isNotBlank(lockKey())) {
                boolean b = doLock(lockKey());
                
                if(!b) {
                    logger.info("定时任务程序:{},被锁定，请稍等,redis key:{},",getTaskName(),lockKey());
                }
            }
            
            doRun();
           
        } catch (Exception e) {
            logger.error("定时任务:{},执行过程中，出现异常",getTaskName(),e);
        } finally {
               if(StringUtil.isNotBlank(lockKey())) {
                   doCleanLock(lockKey());
               }
        }
        
        long endTime = System.currentTimeMillis();
        logger.info("定时任务:{},执行耗时:{}毫秒",getTaskName(), (endTime-startTime));
    }
    
    public abstract boolean doLock(String lockKey) ;
    
    public abstract boolean doCleanLock(String lockKey) ;
    
    public abstract String lockKey() ;
    
    public abstract String getTaskName() ;
    
    public abstract void doRun() throws Exception;
}
