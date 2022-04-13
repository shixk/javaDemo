package com.xuekai.foryou;

public abstract class CacheFather<T,K> {
    private int capacity;
    public abstract void put(T key,K val);

    public abstract K get(T key);
}
