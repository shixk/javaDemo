package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/15
 * @Description 寻找两个字符串的最长公共子串长度
 *              推导公式如下：
 *              当A[i] != B[j]，dp[i][j] = 0
 *              否则 dp[i][j] = dp[i - 1][j - 1] + 1
 **/
public class LcsDp {

    private static int getLCSStr(String s,String t){
        int result=0;

        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<t.length()+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    result=Math.max(dp[i][j],result);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String s1="abcs345ddsgskkdssdg*=9987";

        String s2="asfasgaabc0009987$%asf";

        int re = getLCSStr(s1,s2);

        System.out.println(re);

    }
}
