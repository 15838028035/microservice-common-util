package com.zhongkexinli.micro.serv.common.task;

import java.util.concurrent.ScheduledFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import com.zhongkexinli.micro.serv.common.config.SpringContextUtil;



/**
 *公共定时任务
 */
public abstract class AbstractScheduleTask  extends AbstractTaskRun implements Runnable{

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    
    private ThreadPoolTaskScheduler threadPoolTaskScheduler = (ThreadPoolTaskScheduler) SpringContextUtil.getBean("threadPoolTaskScheduler");
    
    private ScheduledFuture<?> future;

    public void setCron(String cron) {
        stopCron();
        future = threadPoolTaskScheduler.schedule(() -> 
                run()
        	 
        , new CronTrigger(cron));
    }

    
    @Override
    public boolean doLock(String lockKey) {
        return false;
    }


    @Override
    public boolean doCleanLock(String lockKey) {
        return false;
    }

    public void stopCron() {
        if (future != null) {
            future.cancel(true);
        }
    }

    public Boolean getStatus() {
        return future.isCancelled();
    }
}
