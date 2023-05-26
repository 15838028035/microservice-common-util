package com.zhongkexinli.micro.serv.common.thread;
public class RunA implements Runnable {
        @Override
        public void run() {
            System.out.println("run a");
            String a = null;
            a.length();
        }
        
    }