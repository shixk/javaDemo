package com.xuekai.algorithm;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "Sunday";
        String s2 = "Saturday";
        EditDistance editDistance = new EditDistance();
        int re = editDistance.solution(s1,s2);
        System.out.println(re);
    }

    private int solution(String s1,String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        //初始化
        dp[0][0] = 0;
        for(int i = 1;i<=m;i++){
            dp[i][0] = i;
        }

        for(int j =1 ; j<=n ; j++){
            dp[0][j] = j;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
        }


        return dp[m][n];
    }

    private int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }
}
