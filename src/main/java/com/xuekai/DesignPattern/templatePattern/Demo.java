package com.xuekai.DesignPattern.templatePattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/23
 * @Description
 **/
public class Demo {
    public static void main(String[] args) {
        BeverageTemplate b1=new Coffee();
        b1.CreateBeverage();
        System.out.println("*****************************");

        BeverageTemplate b2=new Tea();
        b2.CreateBeverage();

    }
}
