package com.fengzhi.basislearning.gl.day19;

public class Ticket {
    public static void learn() {
        TicketRunnable r = new TicketRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
