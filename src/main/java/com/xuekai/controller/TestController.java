package com.xuekai.controller;

import java.util.HashMap;

import com.xuekai.entity.People;

public class TestController {
	public static void main(String[] args) {
		
		HashMap<String,People> map1=new HashMap<>();
		HashMap<String,People> map2=new HashMap<>();
		People p1=new People();
		p1.setAge(12);
		p1.setName("xuekai");
		People p2=new People();
		p1.setAge(13);
		p1.setName("xiaoming");
		People p3=new People();
		p1.setAge(16);
		p1.setName("zhanghong");
		
		map1.put("xuekai", p1);
		map1.put("xiaoming", p2);
		map1.put("zhanghong", p3);
		map1.put("coco", null);
		
		map2.put("xuekai", p1);
		map2.put("xiaoming", p2);
		map2.put("zhanghong", p3);
		
	map1.remove("coco");
		System.out.println(map1.equals(map2));
	
	} 
	
	public static void main1(String[] args) {
		People p=new People();
		p.setAge(20);
		p.setName("aa");
		System.out.println(p.getName());
		People p1=p;
		p1.setName("bb");
		System.out.println(p.getName());
		
		People p2=new People();
		p2.setAge(20);
		p2.setName("bb");
		
		System.out.println(p.equals(p2));
		System.out.println(p==p2);
		
	}
}
