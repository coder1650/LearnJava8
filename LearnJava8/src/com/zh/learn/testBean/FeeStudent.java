package com.zh.learn.testBean;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 学生类包含姓名，分数，待付费用，每个学生可以根据各自不同的分数得到相应的折扣，用于减免部分费用
 * @author beiguo
 *
 */
public class FeeStudent {
	private String firstName;
	private String lastName;
	private double grade;
	private double feeDiscount =0.0;
	private double baseFee = 2000.0;
	public FeeStudent(String firstName, String lastName, double grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}
	
	public FeeStudent updateStudentFee(FeeStudent student,Predicate<FeeStudent> predicate,Consumer<FeeStudent> consumer){
		if(predicate.test(student)){
			consumer.accept(student);
		}
		return student;
	}
	
	public void printFee(){
		double newFee = baseFee - (baseFee * getFeeDiscount()) / 100;
		System.out.println("The fee after discount:"+newFee);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public double getFeeDiscount() {
		return feeDiscount;
	}

	public void setFeeDiscount(double feeDiscount) {
		this.feeDiscount = feeDiscount;
	}

	public double getBaseFee() {
		return baseFee;
	}

	public void setBaseFee(double baseFee) {
		this.baseFee = baseFee;
	}

}
