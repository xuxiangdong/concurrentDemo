package com.synway.demo.threadlocal;

import java.util.Collection;

public class ThreadLocalTest {
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        localVar.set("main");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("t1");
                print("t1");
                System.out.println("t1=" + localVar.get());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                localVar.set("t2");
                print("t2");
                System.out.println("t2=" + localVar.get());
            }
        });
        t1.start();
        t2.start();
        System.out.println(localVar.get());
    }

}
