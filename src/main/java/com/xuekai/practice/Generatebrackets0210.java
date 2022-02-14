package com.xuekai.practice;

import java.util.ArrayList;
import java.util.List;

public class Generatebrackets0210 {

    public void solution(List<String> re,int left,int right,String str){
        if(left==0 && right==0){
            re.add(str);
            return;
        }

        if(left>0){
            solution(re,left-1,right,str+"(");
        }

        if(left<right){
            solution(re,left,right-1,str+")");
        }

    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        Generatebrackets0210 instance = new Generatebrackets0210();
        instance.solution(result,3,3,"");

        System.out.println(result);
    }
}
