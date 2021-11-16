package com.xuekai.algorithm;

/**
 * 爬楼梯
 *
 * 思路
 *  if(n==1) return 1;
 *  if(n==2) return 2;
 *
 *  if(n>=3) return dp[i-1] +dp[i-2];
 */
public class ClimbStair {

    public int solution(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n>=1){
            dp[1] = 1;
        }

        if(n>=2){
            dp[2] = 2;
        }

        if(n>=3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }
}
