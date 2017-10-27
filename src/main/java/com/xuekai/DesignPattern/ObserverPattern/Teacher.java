package com.xuekai.DesignPattern.ObserverPattern;

import java.util.List;

public class Teacher implements ISubject{
    private String phone;

    private List<Student> studentList;

    @Override
    public int AddObserver(Object item) {

        studentList.add((Student) item);
        return 1;
    }

    @Override
    public int removeObserver(Object item) {

        studentList.remove(item);
        return 0;
    }

    @Override
    public void notice() {
        studentList.forEach(s->s.update(this));
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

