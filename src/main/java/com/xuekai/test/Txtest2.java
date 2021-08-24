package com.xuekai.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import javafx.util.Pair;

import java.util.*;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/8
 * @Description
 **/
public class Txtest2 {
//    {101, 80, 20, -1, 50, 1000000, 100, 30, 50, 20, 50}
//    length = N
//    K = 100
//
//    O(N)时间空间复杂度内，找到所有加和等于K的数对
//
//    {101, -1}
//    {80, 20}
//    {50, 50}

    public static void main(String[] args) {

        int[] arr = {101, 80, 20, -1, 50, 1000000, 100, 30, 50, 20, 50};
        List<Map<Integer,Integer>> result = solution(arr,100);

        System.out.println(result);

        Long poiId = 143072327668582l;
        Integer s = poiId.intValue();

        System.out.println("int value ="+s);
    }

    private static List<Map<Integer,Integer>> solution(int[] arr,int k){
        List<Map<Integer,Integer>> list = Lists.newArrayList();
        Map<Integer,Integer> map = Maps.newHashMap();
        for(Integer i :arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,0);
            }
        }

        for(Integer i: arr){
            Integer key = k-i;

            if(map.containsKey(key)){

                if(i==key && map.get(key).equals(0)){
                    continue;
                }
                Map<Integer,Integer> rMap = Maps.newHashMap();
                rMap.put(i,key);
                list.add(rMap);

                //如果只有一个这个值则删除，如果有多个则减一
                if(map.get(key).equals(0)){
                    map.remove(key);
                }else {
                    map.put(key,map.get(key)-1);
                }

                if(map.get(i)!=null) {
                    if (map.get(i).equals(0)) {
                        map.remove(i);
                    } else {
                        map.put(key, map.get(i) - 1);
                    }
                }
            }
        }

        return list;
    }
}
