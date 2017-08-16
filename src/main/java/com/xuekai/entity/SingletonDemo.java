package com.xuekai.entity;

/**
 * 单例doublecheck实例
 * @author shixk1
 *
 */
public class SingletonDemo {
	//为了测试增加一个属性
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private volatile static  SingletonDemo instance;
	
	private SingletonDemo(){
		
	}
	
	public static SingletonDemo getInstance(){
		if(instance==null){
			synchronized(SingletonDemo.class){
				if(instance==null){
					instance=new SingletonDemo();
				}
			}
		}
		
		return instance;
	}
	
}
