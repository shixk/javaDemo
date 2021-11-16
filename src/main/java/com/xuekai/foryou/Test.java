package com.xuekai.foryou;

import com.xuekai.service.Animal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    // 1，2，3，4
    // 1，2，3｜1，3，2｜2，1，3｜
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //不同的策略，加载进来
        Class c = Class.forName("com.xuekai.serviceImpl.Bird");

        //接口对外公开，统一处理流程
        Animal an = (Animal) c.newInstance();

        System.out.println(an.showName());

        Set<Integer> set = new HashSet<>();

    }


}
