package com.xuekai.controller;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAndDequeDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();  
		queue.offer("xuekai");
		queue.offer("xiaoming");
		queue.offer("123");
		
		String str=null;
		while((str=queue.poll())!=null){
			System.out.println(str);
		}
	}
}
