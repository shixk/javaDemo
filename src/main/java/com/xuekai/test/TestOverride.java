package com.xuekai.test;

import com.xuekai.entity.People;
import com.xuekai.entity.Student;
import com.xuekai.entity.Teacher;

public class TestOverride {

    public static void main(String[] args) {

        People student = new Student();
        student.sayHello();

        People teacher = new Teacher();
        teacher.setAge(18);
        teacher.setName("jieyi");
        teacher.setSubNo("aaa");
        teacher.sayHello();
    }

}
