package com.xuekai.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/22
 * @Description 一些测试
 **/
public class TestMethod {

    public static void main(String[] args) {
        int k =0 ;

        String str = getCount(k++);

        System.out.println(str);

        HashMap map = new HashMap();


        List<Integer> idList= Lists.newArrayList();


        idList.add(100);
        idList.add(3);
        idList.add(92);
        idList.add(109);
        idList.add(33);

        List<Integer> tempList = Lists.newArrayList();
        tempList.add(7);
        tempList.add(8);
        tempList.add(9);

        tempList.addAll(idList);

        sortlist(tempList);

        System.out.println(tempList.toString());


    }


    private static String getCount(int k){

        return String.valueOf(k);
    }


    private static void sortlist(List<Integer> list){
        //List<Integer> tempList = list.stream().filter(p->p.equals(7)).collect(Collectors.toList());

        //tempList.sort(Comparator.comparing(Integer::intValue).reversed());

        //list = tempList;

        List list1 = new ArrayList();
        list.removeAll(list1);

        List<Integer> anotherList = list.stream().filter(p->!p.equals(7)).collect(Collectors.toList());
        list.removeAll(anotherList);
        anotherList.sort(Comparator.comparing(Integer::intValue).reversed());
        list.addAll(anotherList);

        System.out.println(list);

    }
}
