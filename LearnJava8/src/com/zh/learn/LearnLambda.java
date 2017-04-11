package com.zh.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.zh.learn.funService.FunService01;

public class LearnLambda {
	
	@Test
	public void learn01(){
		Runnable r = () -> System.out.println("this is a lambda");
		Thread t = new Thread(r);
		t.start();
		String str = "this is common way";
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(str);
			}
		});
		t2.start();
	}
	
	@Test
	public void learn02(){
		//定义一个lambda表达式
		BinaryOperator<Long> add = (x,y) -> x+y;
		BinaryOperator<Long> mul = (x,y) -> x*y;
//		Predicate<Integer> atLeasts = x -> x>6;
//		dd(new HashMap<>());//java8中能根据方法签名来推断出泛型的类型，这在java7中是不行的
	}
	
	@Test
	public void learn03(){
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list.stream().filter(str -> str.equals("aa")).count());
	}
	
	@Test
	public void learn04(){
		List<String> list = Stream.of("a","b","c").map(str -> str.toUpperCase()).collect(Collectors.toList());
		list.stream().limit(2).forEach(s -> System.out.println(s));
	}
	
	@Test
	public void learn05(){
//		FunService01 f = (x,y) -> x*y;
//		System.out.println(f.getSum(3, 5));
		List<String> list = Stream.of("a","b","c").collect(Collectors.toList());
		list.forEach(e -> {System.out.println(e.toString());});
	}
	
	
	public void dd(HashMap<String,String> map){
		System.out.println("dd");
	}

}
