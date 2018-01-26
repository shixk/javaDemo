package com.xuekai.DesignPattern.strategyPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/26
 * @Description
 **/
public class RedDuckFlying implements FlyingStrategy{
    @Override
    public void performFly() {
        System.out.println("振翅高飞");
    }
}
