package com.xuekai.foryou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 思路：将数组元素累加，得到sum
 * 将数组分为sum个格子，单位为1，每个元素k，会占k个格子，找到每个元素，占用的格子起点和终点[low,high]即可，
 * 如果生产的随机数x，落在某个格子的范围中，就是这个范围对应的元素k
 * 定义结构Map<Map<low,high>,Integer>
 */
public class Suiji {

    private static Random r = new Random(100);

    public static void main(String[] args) {
        int[] arr = {2,3,5,10};

        Suiji instance = new Suiji();
        for(int i =0;i<10;i++){
            System.out.println(instance.solution(arr));
        }
    }

    public int solution(int[] arr){
        Arrays.sort(arr);

        int sum =0;
        for(int i:arr){
            sum +=i;
        }

        Map<NumNode,Integer> map = new HashMap<>();
        int pre = 0;
        for(int i=0;i<arr.length;i++){
            int low = pre;
            int high = pre+arr[i];
            NumNode key = new NumNode();
            key.low = low;
            key.high = high;

            map.put(key,arr[i]);
            pre = high;
        }

        //随机数字
        int x = r.nextInt(sum+1);

        int re = 0;
        for(Map.Entry entry : map.entrySet()){
            NumNode k = (NumNode) entry.getKey();
            int L = k.low;
            int H = k.high;

            if(x>=L && x<=H){
                re = (Integer) entry.getValue();
                break;
            }
        }

        return re;
    }


    public class NumNode{
        int low;
        int high;
    }
}
