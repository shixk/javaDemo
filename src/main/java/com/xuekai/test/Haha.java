package com.xuekai.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Haha {


    public static void main(String[] args) {
        List<User> list = Lists.newArrayList();
        User user1 = new User();
        user1.setType(0);
        user1.setName("AA");
        list.add(user1);

        User user2 = new User();
        user2.setType(1);
        user2.setName("BB");
        list.add(user2);

        User user3 = new User();
        user3.setType(0);
        user3.setName("Cc");
        list.add(user3);

        List<User> sortList = list.stream().sorted(Comparator.comparing(User::getType).thenComparing(User::getName).reversed()).collect(Collectors.toList());

        System.out.println(list);

        List<User> listNew = new ArrayList<>();
        List<User> filterList = list.stream().filter(p->p.getType().equals(1)).collect(Collectors.toList());
        for(User user:filterList){
            listNew.add(user);
        }
        list = listNew;
        System.out.println(filterList);
        System.out.println(list);
    }
}
