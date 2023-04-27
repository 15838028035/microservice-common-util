package com.zhongkexinli.micro.serv.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TasksWithoutLockTest extends Thread {

    private static int num = 0;
    private int id;

    public TasksWithoutLockTest(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Thread" + id + "执行结果num:" + num++);
//        try {
//            Thread.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        //ExecutorService exec = Executors.newFixedThreadPool(1);
        ExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 1000; i++) {
            exec.submit(new TasksWithoutLockTest(i));
        }

        exec.shutdown();

    }
}