package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
 
    public static void main(String[] args) {
 
       try {
           createThreadDemo();
       } catch (RejectedExecutionException e) {
           e.printStackTrace();
           System.exit(-1);
       }
 
    }
 
    private static void createThreadDemo() throws RejectedExecutionException {
 
        // 等待队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10000);
 
        // 创建线程池, 核心线程数为5, 最大线程数为10
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, workQueue);
 
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
 
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(300L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
 
            System.out.println("创建第" + i + "个线程后, 线程池情况:" + pool.toString());
        }
    }
 
}