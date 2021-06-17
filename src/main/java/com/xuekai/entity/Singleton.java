package com.xuekai.entity;

import lombok.Synchronized;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/2
 * @Description 双重检索 创建单例
 *              原则：3私一公开
 **/
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton(){

    }
    private static Singleton getInstance(){
        if(instance == null){
             synchronized(Singleton.class) {
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
