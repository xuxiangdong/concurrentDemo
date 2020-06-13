package com.synway.demo.demo2;

public class Character implements Runnable {
    private Object object;

    public Character(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            for (char i = 'A'; i <= 'Z'; i++) {
                    System.out.println(i);
                object.notifyAll();
                if (i < 'Z') {
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
