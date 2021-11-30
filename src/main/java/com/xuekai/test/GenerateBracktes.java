package com.xuekai.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class GenerateBracktes {

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();

        int n = 3;
        solution("",3,3,res);

        System.out.println(res);
    }

    private static void solution(String str,int left,int right,List<String> res){
        if(left==0 && right==0){
            res.add(str);
            return;
        }

        if(left>0){
            solution(str+"(",left-1,right,res);
        }

        if(left<right){
            solution(str+")",left,right-1,res);
        }
    }
}
