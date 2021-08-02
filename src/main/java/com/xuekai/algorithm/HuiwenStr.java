package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/2/23
 * @Description
 **/
public class HuiwenStr {


    /**
     * 暴力破解:遍历字符串所有的子串，逐个去判断是否为一个回文子串
     * @param str
     * @return
     */
    private static String getLastHuiwenStr(String str){
        String result="";

        for(int i=0;i<str.length();i++){
            if(i==str.length()-1){
                break;
            }

            for(int j=i+1;j<=str.length();j++){
                if(j-i==1){
                    continue;
                }

                String temp = str.substring(i,j);
                if(isHuiwen(temp)&&temp.length()>result.length()){
                    result=temp;
                }
            }
        }

        return result;
    }


    private static boolean isHuiwen(String str){
        int i = 0;
        int j = str.length()-1;
        boolean flag = true;
        while (i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                flag = false;
                break;
            }

        }

        return flag;
    }

    public static void main(String[] args) {

        String s1 = "aba";

        String s2 = "aabasbb";

        System.out.println(isHuiwen(s1));

        System.out.println(isHuiwen(s2));


        String s3 = "123ascgaa8aag";

        System.out.println(getLastHuiwenStr(s3));


        String str = "158";

        int i = str.charAt(2)-'0';

        System.out.println(i);
    }
}
