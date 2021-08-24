package com.xuekai.test;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/16
 * @Description 打家劫舍问题
 *              你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *              如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，
 *              能够偷窃到的最高金额
 *
 *              地推公式 Max(a[i-2]+a[i],a[i-1]);
 **/
public class RobberTest {

    public static void main(String[] args) {
        int[] arr = {8,12,100,39,78,200,1};

        int result = solution(arr);

        System.out.println(result);
    }

    private static int solution(int[] a){
        int[] dp = new int[a.length];
        dp[0] = a[0];
        dp[1] = Math.max(a[0],a[1]);
        for(int i=2;i<a.length;i++){
            dp[i] = Math.max(a[i]+dp[i-2],dp[i-1]);
        }

        return dp[a.length-1];
    }
}
