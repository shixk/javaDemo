package com.xuekai.algorithm;

import java.util.Arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/4
 * @Description 零钱兑换，题目如下
 *              coins=[1,2,5,7] ,amount=11
 *              请输出最少组合出该金额的硬币数量
 **/
public class CoinChange {

    /**
     * 情况1  amount=0 时，返回0
     * 情况2  当amount在金币数组中时，返回1
     * 情况3  动态转移方程 Min(1+dp[(amount-coins[0-j]]);
     * @param coins
     * @param amount
     * @return
     */
    private static int solution(int[] coins,int amount){
        int len = coins.length;

        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=0;i<len;i++){
            if(amount>=coins[i]){
                dp[coins[i]]=1;
            }
        }

        //从1到amount赋值
        for(int i = 1;i<=amount;i++){
            //代表前边已经赋值过了
            if(dp[i]!=-1){
                continue;
            }

            if(i-coins[0]<0){
                continue;
            }

            int res = 1+dp[i-coins[0]];
            for(int j=1;j<len;j++){
                if(i>coins[j]){
                    res=Math.min(1+dp[i-coins[j]],res);
                }else {
                    continue;
                }
            }
            dp[i]=res;
        }


        return dp[amount]==0?-1:dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {2,3,6};
        int amount = 22;

        int result = solution(coins,amount);
        System.out.println(result);

    }
}
