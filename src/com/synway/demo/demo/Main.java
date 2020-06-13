package com.synway.demo.demo;

public class Main {
    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice(new Object(), 5);
        new Thread(ticketOffice,"窗口1").start();
        new Thread(ticketOffice,"窗口2").start();
        new Thread(ticketOffice,"窗口3").start();
        new Thread(ticketOffice,"窗口4").start();
        new Thread(ticketOffice,"窗口5").start();
        new Thread(ticketOffice,"窗口6").start();
        new Thread(ticketOffice,"窗口7").start();
        new Thread(ticketOffice,"窗口8").start();
        new Thread(ticketOffice,"窗口9").start();
        new Thread(ticketOffice,"窗口10").start();
        new Thread(ticketOffice,"窗口11").start();
        new Thread(ticketOffice,"窗口12").start();
    }
}
