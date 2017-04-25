package com.zh.learn;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.zh.learn.testBean.FeeStudent;
import com.zh.learn.testBean.Persion;
import com.zh.learn.testBean.Persion.Sex;

public class LearnMethodQuote {
	
	@Test
	public void test01(){
		LocalDate MIN = LocalDate.of(2017, 1, 1);
		System.out.println(MIN);
	}
	
	@Test
	public void test02(){
		Persion p[]  = new Persion[5];
		p[0] = new Persion("小明1",LocalDate.of(2002, 7, 4),Sex.FEMALE);
		p[1] = new Persion("小明2",LocalDate.of(2009, 2, 1),Sex.FEMALE);
		p[2] = new Persion("小明3",LocalDate.of(2006, 6, 4),Sex.FEMALE);
		p[3] = new Persion("小明4",LocalDate.of(2015, 3, 3),Sex.FEMALE);
		p[4] = new Persion("小明5",LocalDate.of(2010, 4, 5),Sex.FEMALE);
		
		//lambda方式
//		Arrays.sort(p,(p1,p2) -> p2.getBirthday().compareTo(p1.getBirthday()));
		//方法引用：调用静态方法
		Arrays.sort(p,Persion::compareByAge);
		Stream.of(p).forEach(pp -> System.out.println(pp.getName()+":"+pp.getBirthday()));
 	}
	
	@Test
	public void test03(){
		List<String> strs = Stream.of("adD","12dd","4eAD","Ddd").collect(Collectors.toList());
		strs.removeIf(str -> str.length() <= 3);
//		for (String str : strs) {
//			if(str.length() <= 3){
//				strs.remove(str);
//			}
//		}
		strs.forEach(System.out::println);
	}
	
	@Test
	public void test04(){
		FeeStudent fStudent = new FeeStudent("李", "四", 80);
		fStudent.updateStudentFee(fStudent, f -> f.getGrade() > 70, s -> s.setFeeDiscount(20));
		fStudent.printFee();
	}

}
