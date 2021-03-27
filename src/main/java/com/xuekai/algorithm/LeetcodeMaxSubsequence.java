package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/24
 * @Description 最大子序列和
 *              输入数组[-2,1,-3,4,-1,2,1,-5,4]
 *              输出 6
 *              子序列为[4,-1,2,1]
 **/
public class LeetcodeMaxSubsequence {

    private static int getMaxResult(int[] nums){
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);

            if(dp[i]>max){
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int res = getMaxResult(nums);

        System.out.println(res);
    }
}
