package com.synway.demo.demo;

public class TicketOffice implements Runnable {
    private Object object;
    private int ticketNum;

    public TicketOffice(Object object, int ticketNum) {
        this.object = object;
        this.ticketNum = ticketNum;
    }

    @Override
    public void run() {
        while (ticketNum > 0) {
            synchronized (object) {
                if (ticketNum <= 0) {
                    System.out.println(Thread.currentThread().getName() + "没有票了");
                } else {
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --ticketNum + "张票");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
