package com.xuekai.test;

import com.google.common.collect.Lists;
import com.xuekai.entity.People;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/8
 * @Description
 **/
public class Practise {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<String> list= Lists.newArrayList();
        list.add("zhang");
        list.add("li");
        list.add("wang");

        List<String> list1=Lists.newArrayList();

        list1.addAll(list);

        System.out.println(String.join(",",list1));
        //------------------------------------------------

        Class cz=People.class;
        People demo=(People)cz.newInstance();
        Field f=cz.getDeclaredField("name");
        f.setAccessible(true);
        f.set(demo,"xuekai");

        System.out.println(demo.getName());

    }
}
