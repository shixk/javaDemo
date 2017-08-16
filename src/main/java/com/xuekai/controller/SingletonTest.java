package com.xuekai.controller;

import com.xuekai.entity.SingletonDemo;

public class SingletonTest {
	public static void main(String[] args) {
		SingletonDemo singletonDemo1=SingletonDemo.getInstance();
		singletonDemo1.setName("xuekai111");
		System.out.println("singletonDemo1 的属性name值："+singletonDemo1.getName());
		SingletonDemo singletonDemo2=SingletonDemo.getInstance();
		singletonDemo2.setName("xuekai222");
		System.out.println("singletonDemo1 的属性name值："+singletonDemo1.getName());
		
	}
	
	
}
