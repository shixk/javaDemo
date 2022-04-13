package com.xuekai.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 给出数组，找出能被3整除的最大子序列和
 *
 * 输入：[3,6,5,1,8]
 * 输出：18
 */
public class Divide3Maxsum {


    public static void main(String[] args) {
        int[] nums = {2,19,6,16,5,10,7,4,11,6};

        System.out.println(new Divide3Maxsum().solution(nums));
    }


    /**
     * 思路就是动态规划，定义dp[i][j],其中j为固定的0，1，2三列
     *               结合该题目，恰好所有和整除3的余数只有0，1，2三种情况
     *               所以前一个值加上当前值nums[i]如果余数不是0的话，那么等于与dp[i-1][1]或dp[i-1][2]相加有一个余数为0结果
     * @param nums
     * @return
     */
    public int solution(int[] nums){
       int[][] dp = new int[nums.length][3];

       //先初始化第一行
        dp[0][1] = dp[0][2] = Integer.MIN_VALUE;

        if (nums[0] % 3 == 0) {
            dp[0][0] = nums[0];
        } else if (nums[0] % 3 == 1) {
            dp[0][1] = nums[0];
        } else if (nums[0] % 3 == 2) {
            dp[0][2] = nums[0];
        }

       for(int i=1;i<nums.length;i++){
           int t = nums[i]%3;

           if(t==0){
               dp[i][0] =Math.max(dp[i-1][0],dp[i-1][0]+nums[i]);
               dp[i][1] =Math.max(dp[i-1][1],dp[i-1][1]+nums[i]);
               dp[i][2] = Math.max(dp[i-1][2],dp[i-1][2]+nums[i]);
           }else if(t==1){
               dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+nums[i]);
               dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]+nums[i]);
               dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+nums[i]);
           }else {
               dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]+nums[i]);
               dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+nums[i]);
               dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2]+nums[i]);
           }
       }

       return dp[nums.length-1][0];
    }


    public int solutionLT(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][3];
        dp[0][1] = dp[0][2] = Integer.MIN_VALUE;

        if (nums[0] % 3 == 0) {
            dp[0][0] = nums[0];
        } else if (nums[0] % 3 == 1) {
            dp[0][1] = nums[0];
        } else if (nums[0] % 3 == 2) {
            dp[0][2] = nums[0];
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i]);


            } else if (nums[i] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i]);

            } else if (nums[i] % 3 == 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i]);
            }
        }

        return dp[n - 1][0];
    }


}
