package com.xuekai.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallabelDemo {
	
	public static class MyCallable implements Callable{

		private int flag;
		
		public MyCallable(int flag){
			this.flag=flag;
		}
		@Override
		public String call() throws Exception {
			if(flag==1){
				return "one";
			}
			
			if(flag==2){
				return "two";
			}
			else{
				throw new Exception("An error is occured.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		MyCallable c1=new MyCallable(1);
		MyCallable c2=new MyCallable(2);
		MyCallable c3=new MyCallable(3);
		
		// 创建一个执行任务的服务
        ExecutorService es = Executors.newFixedThreadPool(3);
        try{
        	Future future1=es.submit(c1);
        	System.out.println("c1 completed result:"+future1.get());
        	
        	Future future2=es.submit(c2);
        	System.out.println("c2 completed result:"+future2.get());
        	
        	Future future3=es.submit(c3);
        	System.out.println("c3 completed result:"+future3.get());
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
        
        es.shutdown();
	}
}
