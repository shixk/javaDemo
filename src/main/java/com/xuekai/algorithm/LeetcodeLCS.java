package com.xuekai.algorithm;

/**
 * 最长公共子串
 */
public class LeetcodeLCS {


    public int solution(String s1,String s2){
        int result =0;
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //将最上边与最左边初始化为0
        for(int i=0;i<=s1.length();i++){
            dp[i][0] = 0;
        }

        for(int j=0;j<=s2.length();j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<s1.length();i++){
            for(int j=1;j<s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    result = Math.max(result,dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        LeetcodeLCS instance = new LeetcodeLCS();
        String s1 = "abcde";
        String s2 = "aabcxyz";

        int re = instance.solution(s1,s2);

        System.out.println(re);
    }
}
