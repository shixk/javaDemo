package com.xuekai.DesignPattern.strategyPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/26
 * @Description
 **/
public class Demo {
    public static void main(String[] args) {
        Duck duck=new RedDuck();

        duck.display();
        duck.quack();
        duck.fly();

        System.out.println("===========================");

        Duck duck1=new ToyDuck();
        duck1.display();
        duck1.quack();
        duck1.fly();
    }
}
