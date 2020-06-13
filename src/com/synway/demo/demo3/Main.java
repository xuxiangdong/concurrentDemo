package com.synway.demo.demo3;

public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(new PrintRunnable(object, 1)).start();
        new Thread(new PrintRunnable(object, 2)).start();
        new Thread(new PrintRunnable(object, 3)).start();

    }
}
