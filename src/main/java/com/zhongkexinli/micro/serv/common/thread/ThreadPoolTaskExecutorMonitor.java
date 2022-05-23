package com.zhongkexinli.micro.serv.common.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定时任务线程监控
 */
public class ThreadPoolTaskExecutorMonitor extends ThreadPoolTaskExecutorExt  {

    private static Logger logger = LoggerFactory.getLogger(ThreadPoolTaskExecutorMonitor.class);

    public static ThreadPoolTaskExecutorMonitor threadPoolTaskExecutorMonitor(int corePoolSize, int maximumPoolSize, int keepAliveTime,int queueCapacity, String poolName) {
        return new ThreadPoolTaskExecutorMonitor(corePoolSize, maximumPoolSize,
                keepAliveTime, queueCapacity, poolName);
    }

    /**
     * 调用父类的构造方法，并初始化HashMap和线程池名称
     *
     * @param corePoolSize    线程池核心线程数
     * @param maximumPoolSize 线程池最大线程数
     * @param keepAliveTime   线程的最大空闲时间
     * @param unit            空闲时间的单位
     * @param workQueue       保存被提交任务的队列
     * @param threadFactory   线程工厂
     * @param poolName        线程池名称
     */
    public ThreadPoolTaskExecutorMonitor(int corePoolSize, int maximumPoolSize, int keepAliveTime,int queueCapacity, String poolName) {
        setCorePoolSize(corePoolSize);
        setMaxPoolSize(maximumPoolSize);
        setKeepAliveSeconds(keepAliveTime);
        setQueueCapacity(queueCapacity);
        setThreadNamePrefix(poolName);
    }
}