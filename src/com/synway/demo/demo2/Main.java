package com.synway.demo.demo2;

/**
 * 在字母打印类里 调用完

 object.notifyAll();//唤醒其它争夺权限的线程
 object.wait();//释放锁，进入等待
 后，拥有对象锁的线程是shuzi
 在数字打印类里 调用完

 object.notifyAll();//唤醒其它争夺权限的线程
 object.wait();//释放锁，进入等待
 后，拥有对象锁的线程是zimu
 */
public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(new Number(object)).start();
        new Thread(new Character(object)).start();
    }
}
