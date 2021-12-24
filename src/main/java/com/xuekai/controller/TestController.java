package com.xuekai.controller;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

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

		//System.out.println(map1.equals(map2));

		map1.putIfAbsent("xuekai",null);

		System.out.println(map1.get("xuekai"));

	}

//	public static void main(String[] args) {
//
//		ClassLoader loader= TestController.class.getClassLoader();
//
//		while (null!=loader){
//			System.out.println(loader);
//			loader=loader.getParent();
//		}
//
//	}
}
