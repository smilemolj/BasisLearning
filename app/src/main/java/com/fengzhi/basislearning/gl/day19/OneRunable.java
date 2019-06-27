package com.fengzhi.basislearning.gl.day19;

public class OneRunable implements Runnable{
	private int num = 0;
	public void run() {
		num++;
		//获取当前线程对象
		Thread thread = Thread.currentThread();
		//获得当前线程名称
		String name = thread.getName();
		System.out.println(name+":"+num);
	}
}
