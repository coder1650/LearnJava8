package com.zh.learn;

import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;

//创建一个线程安全的DateFormatter
public class ThreadSafeDateFormatter {
	
	public static ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MM-yyyy")));

}
