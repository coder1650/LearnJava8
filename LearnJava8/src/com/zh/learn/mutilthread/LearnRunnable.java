package com.zh.learn.mutilthread;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class LearnRunnable {
	
	@Test
	public void test01(){
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName);
		};
		Thread t = new Thread(task);
		t.start();
		System.out.println("Done!");
	}
	
	@Test
	public void test02(){
		Runnable task = () -> {
			try {
				System.out.println("Hello Boy!");
				Thread.sleep(100);
				System.out.println("Hello!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread t = new Thread(task);
		t.start();
		System.out.println("Done!");
	}

}
