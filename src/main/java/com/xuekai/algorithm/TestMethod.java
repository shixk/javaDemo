package com.xuekai.algorithm;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;

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


        List<Long> idList= Lists.newArrayList();

        System.out.println(idList.isEmpty());
    }


    private static String getCount(int k){

        return String.valueOf(k);
    }
}
