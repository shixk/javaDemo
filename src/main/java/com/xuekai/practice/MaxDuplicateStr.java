package com.xuekai.practice;

public class MaxDuplicateStr {

    public static void main(String[] args) {
        String temp = "";
        MaxDuplicateStr instance = new MaxDuplicateStr();

        System.out.println(instance.solution(temp));
    }


    public int solution(String str){
        if(str == null || str==""){
            return 0;
        }

        if(str.length() == 1){
            return 1;
        }
        int max =0;
        int from = 0;
        int to = 1;

        while(to < str.length()) {
            //当前字符在前面的字串当中时
            int site = str.substring(from, to).indexOf(str.charAt(to));
            if (site != -1) {
                if ((to - from) > max) {
                    max = to - from;
                }
                from = from + site + 1;
            }

            to++;
        }

        if((to - from) > max){
            max = to - from;
        }

        return max;
    }
}
