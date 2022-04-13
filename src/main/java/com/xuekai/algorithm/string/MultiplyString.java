package com.xuekai.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相乘
 */
public class MultiplyString {


    public String  solution(String num1,String num2) {
        if(num1 == "0" || num2 == "0"){
            return "0";
        }

        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        List<String> reList = new ArrayList<>();
        for(int i=num1.length()-1;i>=0;i--){
            int carry = 0;
            String str = "";
            int index = num1.length()-1-i;
            while (index>0){
                str = str+"0";
                index--;
            }
            for(int j=num2.length()-1;j>=0;j--){
                int a = arr1[i]-'0';
                int b = arr2[j]-'0';
                int s = a*b+carry;
                int c = s%10;
                carry = s/10;
                str = c+str;
            }
            if(carry>0){
                str = carry + str;
            }
            reList.add(str);
        }

        //System.out.println(reList);
        String result = "0";
        for(String item:reList){
            result = addStr(result,item);
        }

        return result;
    }

    private String addStr(String num1,String num2){
        StringBuilder sb =new StringBuilder();
        int i=num1.length()-1;
        int j=num2.length()-1;

        int carry = 0;
        while (i>=0 || j>=0){
            int a=0 ,b =0;
            if(i>=0){
                a = num1.charAt(i)-'0';
            }

            if(j>=0){
                b = num2.charAt(j)-'0';
            }

            int sum = a+b+carry;
            sb.append(sum%10);
            carry = sum/10;

            i--;
            j--;
        }

        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        String s1 = "9133";
        String s2 = "0";
        MultiplyString instance = new MultiplyString();
        System.out.println(instance.solution(s1,s2));

    }
}
