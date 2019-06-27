package com.fengzhi.basislearning.gl.day19;

public class TicketRunnable implements Runnable{
    //车票数量
    private static int num = 100;

    private String s = "123";
    private Object o = new Object();

    @Override
    public void run() {
        while(true){
            /**
             * 同步代码块的互斥锁对象可以随意指定
             */
//			synchronized (this) {
//				if (num > 0) {
//					String name = Thread.currentThread().getName();
//					System.out.println(name +"卖出第"+num+"张票");
//					num--;
//				}
//			}
            sale1();
        }
    }
    /**
     * 同步方法的互斥锁对象是this
     */
    private synchronized void sale(){
        if (num > 0) {
            String name = Thread.currentThread().getName();
            System.out.println(name +"卖出第"+num+"张票");
            num--;
        }
    }
    /**
     * 互斥锁对象是当前类的class对象
     */
    private static synchronized void sale1(){
        if (num > 0) {
            String name = Thread.currentThread().getName();
            System.out.println(name +"卖出第"+num+"张票");
            num--;
        }
    }
}