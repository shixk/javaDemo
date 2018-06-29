package com.xuekai.jdk8grammer;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.xuekai.DesignPattern.builderPattern.Person;
import com.xuekai.entity.People;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream的特性示例
 */
public class StreamDemo {

    /**
     * 我们可以将stream认为是Iterator的高级应用
     *
     *
     */
    public static void main(String[] args) {

        List<Integer> nums= Lists.newArrayList(1,null,4,null,6,9);
        List<Integer> list=nums.stream().filter(a->a!=null).collect(Collectors.toList());

        list.forEach(a-> System.out.println(a));

        list.forEach(a->{
            int i=4;
            if(a!=i){
                System.out.println(a);
            }
        });


        int s=list.stream().filter(a->a!=null).mapToInt(Integer::new).sum();

        System.out.println("------------------------");

        List<People> peopleList=new ArrayList<>();
        People p1=new People();
        p1.setName("xiaoming");
        p1.setAge(20);
        p1.setSubNo("1001");
        peopleList.add(p1);
        People p2=new People();
        p2.setName("hong");
        p2.setAge(56);
        p2.setSubNo("1001");
        peopleList.add(p2);
        People p3=new People();
        p3.setName("sanyi");
        p3.setAge(44);
        p3.setSubNo("1001");
        peopleList.add(p3);
        People p4=new People();
        p4.setName("fff");
        p4.setAge(87);
        p4.setSubNo("1001");
        peopleList.add(p4);
        People p5=new People();
        p5.setName("meituan");
        p5.setAge(24);
        p5.setSubNo("1001");
        peopleList.add(p5);
        People p6=new People();
        p6.setName("tom");
        p6.setAge(35);
        p6.setSubNo("1003");
        peopleList.add(p6);

        List<Integer> ageList=new ArrayList<>();

        ageList=peopleList.stream().filter(p->p.getSubNo().equals("1001")).map(People::getAge).collect(Collectors.toList());

        System.out.println(ageList);
    }
}
