package com.xuekai.entity;

public class People {
	private String name;
	private Integer age;

	private String subNo;

	public People(String name,Integer age,String subNo){
		this.age=age;
		this.name=name;
		this.subNo=subNo;
	}

	public People(){}

	public String getSubNo() {
		return subNo;
	}

	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public void sayHello(){
		System.out.println("hello people");
	}

}
