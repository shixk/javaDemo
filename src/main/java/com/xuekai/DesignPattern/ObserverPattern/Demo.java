package com.xuekai.DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Teacher teacher=new Teacher();
        teacher.setPhone("13500011111");

        Student student0=new Student("小米");
        Student student1=new Student("Tom");
        Student student2=new Student("沪菜");
        Student student3=new Student("江华");

        List<Student> list=new ArrayList<>();
        list.add(student0);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        teacher.setStudentList(list);
        teacher.notice();
    }
}
