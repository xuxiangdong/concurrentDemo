package com.synway.demo.singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMain {
    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.CountDownLatch c = new CountDownLatch(20);
        Set<String> set = new HashSet<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(Thread.currentThread().getName() + ":" + Singleton2.getInstance());
                    set.add(Singleton2.getInstance()+"");
                    c.countDown();
                }
            });
        }
        c.await();
        System.out.println(set);
        threadPool.shutdown();
    }
}