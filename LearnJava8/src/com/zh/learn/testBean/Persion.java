package com.zh.learn.testBean;

import java.time.LocalDate;

public class Persion {
	
	public enum Sex{
		MALE,FEMALE
	}
	
	private String name;
	private LocalDate birthday;
	private Sex gendar;
	private String address;
	
	public static int compareByAge(Persion p1,Persion p2){
		return p1.getBirthday().compareTo(p2.getBirthday());
	}
	
	
	
	public Persion(String name, LocalDate birthday, Sex gendar) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gendar = gendar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getGendar() {
		return gendar;
	}
	public void setGendar(Sex gendar) {
		this.gendar = gendar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
