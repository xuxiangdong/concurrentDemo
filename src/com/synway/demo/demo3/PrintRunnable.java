package com.synway.demo.demo3;

public class PrintRunnable implements Runnable {
    private static volatile int printNum = 0;
    private Object object;
    private int threadId;

    public PrintRunnable(Object object, int threadId) {
        this.object = object;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while (printNum < 75) {
            synchronized (object) {
                if (printNum / 5 % 3 + 1 == threadId) {
                    for (int i = 0; i < 5; i++) {

                        System.out.println("线程" + threadId + ":" + (++printNum));
                    }
                    object.notifyAll();
                } else {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
