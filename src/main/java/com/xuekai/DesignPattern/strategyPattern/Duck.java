package com.xuekai.DesignPattern.strategyPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/26
 * @Description 鸭子抽象基类
 **/
public abstract class Duck {

    private FlyingStrategy flyingStrategy;


    public void setFlyingStrategy(FlyingStrategy flyingStrategy){
        this.flyingStrategy=flyingStrategy;
    }

    /**
     * 鸭子叫唤
     */
    void quack(){
        System.out.println("嘎嘎嘎");
    }

    //鸭子的外貌
    abstract void display();

    //飞行
    void fly(){
        //使用接口来完成方法的流程
        //真正的执行，由不同的策略去实现
        flyingStrategy.performFly();
    }
}
