package com.xuekai.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class GenerateBrackets {


    public void solution(List<String> res,String subStr,int left,int right){
        if(left==0 && right==0){
            res.add(subStr);
            return ;
        }

        if(left>0){
            solution(res,subStr+"(",left-1,right);
        }

        if(left<right){
            solution(res,subStr+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        GenerateBrackets instance = new GenerateBrackets();
        instance.solution(res,"",3,3);

        System.out.println(res);
    }
}
