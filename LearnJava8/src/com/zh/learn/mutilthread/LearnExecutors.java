package com.zh.learn.mutilthread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class LearnExecutors {
	
	@Test
	public void test01() throws InterruptedException, ExecutionException{
		ExecutorService e = Executors.newSingleThreadExecutor();
		e.submit(() -> {
			System.out.println("hello!!!");
		});
	}
	
	@Test
	public void testo2() throws InterruptedException, ExecutionException, TimeoutException{
		ExecutorService e = Executors.newSingleThreadExecutor();
		Future<Integer> future = e.submit(() -> {
			System.out.println("hello!");
			TimeUnit.SECONDS.sleep(2);
			return 3;
		});
		System.out.println("Future is done:"+future.isDone());
		System.out.println("future result:"+future.get(1,TimeUnit.SECONDS));//将会抛出TimeOutException
		System.out.println("Future is done:"+future.isDone());
	}
	
	@Test
	public void test03(){
		List<Callable<String>> tasks = Arrays.asList(()->"task1",()->"task2",()->"task3");
		ExecutorService e = Executors.newWorkStealingPool();
		try {
			e.invokeAll(tasks).stream().map(future -> {
				try {
					return future.get();
				} catch (InterruptedException | ExecutionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}).forEach(System.out::println);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
	}
	
	@Test
	public void test() throws InterruptedException{
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
		Runnable task = () -> System.out.println("Scheduling:"+System.nanoTime());
		ScheduledFuture<?> sf = schedule.schedule(task, 3, TimeUnit.SECONDS);
		TimeUnit.MICROSECONDS.sleep(1337);
		long remainingDelay = sf.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms", remainingDelay);
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			System.out.println("this begin....");
			System.out.println("this end....");
		};
		executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	}
	
}
