package com.synway.demo.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private final static int VAL = 50;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadpool = Executors.newFixedThreadPool(VAL);
        Set<String> set = new HashSet<>();
        CountDownLatch countDownLatch = new CountDownLatch(VAL);
        for (int i = 0; i < VAL; i++) {
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
//                        System.out.println(Thread.currentThread().getName()+":"+Singleton.getInstance());
                        set.add(""+Singleton.getInstance());
                        countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println(set);
        threadpool.shutdown();
    }
}
