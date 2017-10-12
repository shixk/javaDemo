package com.xuekai.jdk8grammer;

public class lammmbda {
    public static void main(String[] args) {
        Thread thead=new Thread(()->System.out.println("this run on lambda"));
        thead.start();
    }
}
