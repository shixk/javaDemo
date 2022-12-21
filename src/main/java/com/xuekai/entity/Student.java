package com.xuekai.entity;

public class Student extends People{


    public static void main(String[] args) {
        String s="aabbkkk";
        for(int i=0;i<=s.length()-3;i++){
            System.out.println(s.substring(i,i+3));
        }

    }

    public static int solution(String s){
        if(s.length()<3){
            return 0;
        }


        return 3;
    }

    private static boolean isHuiwen(String str){
        int i = 0;
        int j = str.length()-1;
        boolean flag = true;
        while (i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                flag = false;
                break;
            }

        }

        return flag;
    }
}
