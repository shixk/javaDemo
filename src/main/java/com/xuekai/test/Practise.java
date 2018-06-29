package com.xuekai.test;

import com.google.common.collect.Lists;
import com.xuekai.entity.People;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

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

        //------------------------------------------------

        Queue<String> queue=new LinkedList<>();
        String str="1+2-7896+3-11-32";
        Stack<String> stack2=new Stack<>();

        char[] calS = str.toCharArray();
        int i=calS.length-1;
        while(i>=0){

            StringBuffer sb=new StringBuffer();
            if (calS[i] >= '0' && calS[i] <= '9'){
                sb.append(calS[i]);
                int j=--i;
                while (j>=0&&calS[j] >= '0' && calS[j] <= '9'){
                    sb.append(calS[j]);
                    --j;
                }
                queue.offer(sb.reverse().toString());
                i=j;
            }else {
                sb.append(calS[i]);
                stack2.push(sb.toString());
                --i;
            }
        }

        Set<Integer> set=getCalS(str);

        Map<Integer,String> map=getCalAndSign(str);

        System.out.println("完成");

    }


    /**
     * 提取计算公式数字元素，去重 公式格式为 : 33+(22-3+4)-5
     */
    public static Set<Integer> getCalS(String str) {

        char[] calS = str.toCharArray();
        Set<Integer> baseElements = new HashSet();
        for (int i = 0; i < calS.length; i++) {
            if (calS[i] >= '0' && calS[i] <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < calS.length && calS[i] >= '0' && calS[i] <= '9')
                    buffer.append(calS[i++]);
                baseElements.add(Integer.parseInt(buffer.toString()));
            }
        }
        return baseElements;
    }

    //
    public static Map<Integer,String> getCalAndSign(String str){
        char[] calS = str.toCharArray();
        Map<Integer,String> map=new HashMap<>();
        String sign="+";
        for (int i = 0; i < calS.length; i++) {
            //只有第一次不用处理
            if(i!=0){
                int j=i-1;
                sign=String.valueOf(calS[j]);
            }
            if (calS[i] >= '0' && calS[i] <= '9') {
                StringBuffer buffer = new StringBuffer();
                while (i < calS.length && calS[i] >= '0' && calS[i] <= '9')
                    buffer.append(calS[i++]);
                map.put(Integer.parseInt(buffer.toString()),sign);
            }
        }

        return map;

    }
}
