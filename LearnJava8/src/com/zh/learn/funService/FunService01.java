package com.zh.learn.funService;

@FunctionalInterface
public interface FunService01 {
	public final static String DEMO = "";
	public int getSum(int x,int y);
	
	default int byDefault(int a,int b,int c){
		return a+b+c;
	}
}
