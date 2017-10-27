package com.xuekai.DesignPattern.ObserverPattern;

public interface IObserver {

    //触发执行，并显示订阅器的信息
    void update(ISubject subject);
}
