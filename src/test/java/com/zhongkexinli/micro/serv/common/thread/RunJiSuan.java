package com.zhongkexinli.micro.serv.common.thread;
public class RunJiSuan implements Runnable {
        @Override
        public void run() {
           test4(6);
        }
        
        private void test4(int n) {
            // 初期化，下标默认判断
            boolean[] st = new boolean[n+1];
            
            // 素数集合
            int[] primes = new int[n+1];
            int cnt=0;// 素数集合下标
            primes[cnt++]=2;
            int count=0;
            for (int i = 3; i<=n; i+=2) {
                if (!st[i]) {
                    primes[cnt++]=i;
                    for (int j=i*i; j<=n; j+=(i*2)) {
                        st[j] = true;
                        count+=1;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<primes.length;i++) {
                sb.append(primes[i]);
                sb.append(",");
            }
            System.out.println(count+":"+sb.toString());
        }
        
    }