package com.xuekai.DesignPattern.ObserverPattern;

public class Student implements IObserver{

    public Student(String name){
        this.name=name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(ISubject subject) {
        Teacher teacher=(Teacher)subject;
        System.out.println("学生"+this.name+"得到老师的电话："+teacher.getPhone());
    }
}
