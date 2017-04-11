package com.zh.learn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.zh.learn.testBean.Student;

public class LearnStream {
	
	@Test
	public void valueStream(){
		IntStream stream = IntStream.of(new int[]{2,23,20,35});
//		stream.filter(i -> i > 3).sorted().forEach(System.out::println);
//		IntStream.rangeClosed(3, 5).forEach(System.out::println);
		//stream转化成数组
		int[] intArr = stream.toArray();
		//stream转化为集合
		Stream<String> streamC = Stream.of("a","c","g","d").sorted((x,y) -> 1);
		List<String> list = streamC.collect(Collectors.toList());
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	@Test
	public void streamFilter(){
		List<Student> class1 = Stream.of(new Student("zhangsan",18),new Student("xiaoming",20),new Student("wangwu",16),new Student("lisi",15)).collect(Collectors.toList());
		List<Student> class2 = Stream.of(new Student("明明",16),new Student("哄哄",20),new Student("彤彤",19),new Student("单单",13)).collect(Collectors.toList());
		//找出class1中age和class2中age相等得同学
		List<Student> result = class1.stream().filter(s1 -> !class2.stream().filter(s2 -> s1.getAge() == s2.getAge()).collect(Collectors.toList()).isEmpty()).collect(Collectors.toList());
		result.stream().forEach(s -> System.out.println(s.getAge()));
	}
	
	@Test
	public void streamFlatMap(){
		Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(5,6,7));
		//层级结构扁平化:把多个list中得元素放到一个stream中
		List<Integer> intList = stream.flatMap(list -> list.stream()).collect(Collectors.toList());
		intList.stream().forEach(System.out::println);
	}
	
	@Test
	public void streamPeek(){
		Stream<String> stream = Stream.of("hello","world","peek","am","hehe");
		stream.filter(s -> s.length() > 3).peek(System.out::println)
		.map(s -> s.toUpperCase()).peek(System.out::println).collect(Collectors.toList());
	}
	
	@Test
	public void optionalDemo(){
		String str1 = "";
		String str2 = "hello";
		String str3 = null;
		Optional.ofNullable(str2).ifPresent(System.out::println);
	}

}
