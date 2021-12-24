package com.xuekai.algorithm;

public class IntegerBreak {

    public static void main(String[] args) {
        IntegerBreak instance = new IntegerBreak();
        int result = instance.solution(10);

        System.out.println(result);

    }

    public int solution(int n){
        if(n<1){
            return 0;
        }

        int[] memo = new int[n+1];
        //memo[0] = 空着
        memo[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                memo[i] = max(memo[i],j*(i-j),j*memo[i-j]);
            }
        }

        return memo[n];
    }


    private int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
}
