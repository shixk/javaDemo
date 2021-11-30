package com.xuekai.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/13
 * @Description 复原ip地址
 *              输入：25525511135
 *              输出：[255.255.111.35,255.255.11.135]
 **/
public class LeetcodeIpAddress {

    private static List<String> solution(String s){
        List<String> res = new ArrayList();

        getIpAddress(s,1,"",res);

        return res;
    }


    private static void getIpAddress(String s,int k,String address,List<String> res){
        //满足条件的结果
        if(k==5 && s.length()==0){
            res.add(address.substring(0,address.length()-1));
            return;
        }

        if(k>=5){
            return;
        }

        int remain = 5-k;
        //长度不够或者剩余长度超过了最大值也不行
        if(s.length()<remain||s.length()>(3*remain)){
            return;
        }

        for(int i=1;i<=3;i++){
            if(s.length()<i){
                return;
            }
            String part = s.substring(0,i);
            if(isValid(part)){
                getIpAddress(s.substring(i),k+1,address+part+".",res);
            }
        }
    }



    //校验函数：主要验证 每段数字是否为 001 022 等这样0开头的数字
    public static boolean isValid(String s) {
        if(s.isEmpty() || s.length()>3 || (s.length()>1 && s.charAt(0)=='0')){
            return false;
        }else {
            int resInt = Integer.parseInt(s);
            return resInt<=255 && resInt>=0;
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> list = solution(s);
        System.out.println((list));
    }
}
