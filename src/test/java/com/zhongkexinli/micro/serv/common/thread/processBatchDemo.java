package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.CountDownLatch;

public  class processBatchDemo  implements Runnable {

    private CountDownLatch latch;
    private  TestA testA;

    processBatchDemo(CountDownLatch latch, TestA testA) {
        this.latch = latch;
        this.testA = testA;
    }

    @Override
    public void run() {
        /**
         * 操作处理t 对象，按需处理业务逻辑
         */
        System.out.println(testA.getName());
        latch.countDown();
    }
    }