package com.synway.demo.singleton;

public class Singleton2 {
    private Singleton2(){

    }

    private static Singleton2 instance;

    public static Singleton2 getInstance(){
        if(instance == null) {//1：读取instance的值
            instance = new Singleton2();//2: 实例化instance
        }
        return instance;
    }
}
