package com.xuekai.DesignPattern.strategyPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/26
 * @Description
 **/
public class ToyDuck extends Duck{

    public ToyDuck(){
        super();
        super.setFlyingStrategy(new ToyDuckFlying());
    }

    @Override
    void display() {
        System.out.println("我是玩具鸭，我个头很小，在浴缸里游泳");
    }
    @Override
    void quack(){
        System.out.println("吱~吱~吱~");
    }
}
