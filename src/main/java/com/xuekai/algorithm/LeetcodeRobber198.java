package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/1
 * @Description 打家劫舍问题
 *              你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *              如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 *              能够偷窃到的最高金额
 **/
public class LeetcodeRobber198 {

    /**
     * 核心解决方案是动态规划，前i-1项数据的结果，与前i-2项加上当前值进行对比
     * result = Math.max(dp[i-1],dp[i-2]+arr[i]);
     */
    private static int solution(int[] nums){
        int len = nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[len-1];
    }

    public static void main(String[] args) {
        int[] arr = {8,12,100,39,78,200,1};

        int result = solution(arr);

        System.out.println(result);
    }



}
