package com.fengzhi.basislearning.gl.day19;

/**
 * 创建线程的第一种方式
 * 1,创建Thread的子类
 * 2,重写run方法
 * 3,创建给子类对象
 * <p>
 * 创建线程的第二种方式
 * 1,创建实现Runable的子类
 * 2,重写run方法
 * 3,创建实现Runable子类对象
 * 实现Runable子类     r = new 实现Runable子类();
 * 4,创建线程对象
 * Thread t = new Thread(r);
 * 可以使多个线程共享同一个数据
 * <p>
 * 启动线程
 * 使用线程对象调用start方法启动，执行该线程对象所在类的run方法
 * 如果使用Runnable对象创建的线程对象，
 * 该对象调用start方法启动启动时将执行Runable对象所在类的run方法
 * <p>
 * 注意线程已经启动则不再受控制
 */
public class HelloThread {
    public static void learn() {

//		第一种创建线程方式
//		OneThread oneThread = new OneThread();
        //启动线程
//		oneThread.start();
//		System.out.println("你好，我是主线程");
//		使用匿名内部类创建线程对象
//		Thread t = new Thread(){
//			public void run() {
//				System.out.println("我还是子线程");
//			};
//		};

        OneRunable oneRunable = new OneRunable();
        //CPU在多个线程中快速切换
        Thread t1 = new Thread(oneRunable);
        t1.setName("张三");
        Thread t2 = new Thread(oneRunable);
        t2.setName("李四");
        Thread t3 = new Thread(oneRunable);
        t3.setName("王五");
        Thread t4 = new Thread(oneRunable);
        t4.setName("马六");
        Thread t5 = new Thread(oneRunable);
        t5.setName("候七");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
