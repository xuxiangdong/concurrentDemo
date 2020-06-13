package com.synway.demo.demo4;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {
    public static boolean flag = true;
    public static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitTHread = new Thread(new Wait(), "WaitThread");
        waitTHread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            //获取 lock对象监视器 并加锁
            synchronized (lock) {
                //当条件不满足时,继续wait，同时只是暂时释放了lock对象上的锁，并将当前对象防止到对象的等待队列中
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread()
                                + "flag is true. wait@ "
                                + new SimpleDateFormat("HH:mm:ss")
                                .format(new Date()));

                        lock.wait();


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                //当条件满足时,完成工作
                System.out.println(Thread.currentThread()
                        + "flag is true. wait@ "
                        + new SimpleDateFormat("HH:mm:ss")
                        .format(new Date()));


            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            /*
             * 获取对象的监视器
             */
            synchronized (lock) {
                //获取对象上的锁，然后通知等待队列中的所有对象,但这个时候不会释放锁
                System.out.println(Thread.currentThread()
                        + " 持有锁..notify @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                //调用该方法后,将会把所有等待队列中的线程全部移动到同步队列中
                lock.notifyAll();
                //将条件置为 false
                flag = false;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }


            //再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread()
                        + " 再次持有锁..sleep @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    }
}
