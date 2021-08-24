package com.xuekai.algorithm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/9
 * @Description
 **/
public class IncrTest {

    //private static AtomicInteger atomicInteger = new AtomicInteger();
    private static ConcurrentHashMap<String,AtomicInteger> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        int re = incr("test");
        System.out.println(re);

        int c = incr("xuekai");
        System.out.println(c);
        int d = incr("test");
        System.out.println(d);

        int e = incr("test");
        System.out.println(e);
    }

    private static int incr(String key){
        AtomicInteger atomicInteger;
        if(map.containsKey(key)){
            atomicInteger = map.get(key);
            atomicInteger.getAndIncrement();
        }else {
            atomicInteger = new AtomicInteger(0);
            atomicInteger.getAndIncrement();
            map.put(key,atomicInteger);
        }

        return atomicInteger.get();

    }



}
