package com.xuekai.DesignPattern.ObserverPattern;

public interface ISubject<T> {

    int AddObserver(T item);

    int removeObserver(T item);

    void notice();
}
