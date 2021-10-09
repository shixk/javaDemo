package com.xuekai.algorithm.arrays;

/**
 * 最小路径和
 * 只能向右，向下寻路
 * [1,3,1]
 * [4,5,1]
 * [3,7,1]
 * 从grid[0,0] 到 grid[2,2]最小路径和是7
 *
 * 解题思路：贪心算法，目标点的值等于该位置的值+左边/上边的较小值
 *         动态规划公式：dp[i][j] = grid[i][j] + Min(dp[i-1][j],dp[i][i-1]);
 */
public class Minimalpath {

    private static int solution(int[][] grid){
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i< m ;i++){
            for(int j = 0 ; j< n ; j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else if(i==0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1,3,1},{4,5,1},{3,7,1}};
        int re = solution(arr);

        System.out.println(re);
    }
}
