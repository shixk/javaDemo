package com.xuekai.DesignPattern.strategyPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/26
 * @Description
 **/
public class RedDuck extends Duck{

    public RedDuck(){
        super();
        super.setFlyingStrategy(new RedDuckFlying());
    }

    @Override
    void display() {
        System.out.println("我是红嘴鸭，我的嘴巴是红色的");
    }
}
