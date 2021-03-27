package com.xuekai.algorithm;

import java.util.HashMap;

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
    }


    private static String getCount(int k){

        return String.valueOf(k);
    }
}
