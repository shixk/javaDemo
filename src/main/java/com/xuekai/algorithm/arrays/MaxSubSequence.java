package com.xuekai.algorithm.arrays;

/**
 * 最大连续子序列和
 *
 * 动态规划
 */
public class MaxSubSequence {

    public int solution(int[] arr){
        int max = arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);

            max = Math.max(dp[i],max);
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubSequence instance = new MaxSubSequence();
        System.out.println(instance.solution(arr));
    }
}
