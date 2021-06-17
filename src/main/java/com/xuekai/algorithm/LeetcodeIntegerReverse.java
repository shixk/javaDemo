package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/18
 * @Description
 **/
public class LeetcodeIntegerReverse {

    public static int reverse(int x){
        long n=0;
        while(x!=0){
            //尾部最后一个数字
            long temp = x%10;
            n = n*10+temp;
            x=x/10;
        }

        //超过int值的范围时，直接返回0
        return (int)n==n?(int)n:0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
