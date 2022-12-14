package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestB {

    public static void main(String []args) {
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 10,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),
                new ThreadPoolExecutor.AbortPolicy()); // 添加 AbortPolicy 拒绝策略
        for (int i = 0; i < 6; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

    }
}
