package com.xuekai.jdk8grammer;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListeningExecutorService;
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

        System.out.println("--------------");
        System.out.println(s);
    }
}
