package com.xuekai.entity;

/**
 * @Author shixuekai
 * @CreateDate 2019/12/25
 * @Description
 **/
public class Teacher extends People{

    private String course;

    @Override
    public void sayHello(){
        System.out.println("hello my teacher :"+this.course);
    }
}
