package com.xuekai.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/18
 * @Description 输入：s = "the sky is blue"
                输出："blue is sky the"
 **/
public class ProcessWordReverse {

    public String solution(String str){
        String result = "";
        String[] arr = str.split(" ");
        List<String> list = new ArrayList<>();

        for(int i =arr.length-1;i>=0;i--){
            if(!arr[i].equals("")){
                list.add(arr[i]);
            }
        }

        for(String temp : list){
            result = result + temp + " ";
        }



        return result.trim();
    }


    public static void main(String[] args) {
        ProcessWordReverse clz = new ProcessWordReverse();

        String s = "a good   example";

        System.out.println(clz.solution(s));
    }
}
