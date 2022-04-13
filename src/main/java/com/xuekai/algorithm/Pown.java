package com.xuekai.algorithm;

/*
    一个数的n次方

    思路：不断递归，将3的10次幂，拆解为两个3的5次幂相乘
         然后拆解为3的5次幂为：3的2次幂乘以3的2次幂再乘以3
         最终回到数值出口
 */
public class Pown {

    public double myPow(double x,int n){
        if(n==0){
            return (double)1;
        }

        if(n>0){
            return quickPow(x,n);
        }else {
            x = 1.0/x;
            long a = 0-(long)(n);

            return quickPow(x,a);
        }
    }


    private double quickPow(double x,long n){
        if(n==1){
            return x;
        }

        double ret = quickPow(x,n/2);
        return n%2 ==0?ret*ret:ret*ret*x;
    }


    public static void main(String[] args) {
        double x=2.0000;
        int n=-10;

        System.out.println(new Pown().myPow(x,n));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
