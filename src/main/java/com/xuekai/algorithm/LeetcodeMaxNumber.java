package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/19
 * @Description 输入一个都是整数的数组，输出这些数字组成的最大数字
 *              输入 [195,23,56,235,7]
 *              输出 75623523195
 **/
public class LeetcodeMaxNumber {

    public static void main(String[] args) {
        int[] arr = {195,23,56,235,7};
        String result = getMaxNumber(arr);

        System.out.println(result);

        //System.out.println("1234".compareTo("123"));
    }


    private static String getMaxNumber(int[] arr){
        int len = arr.length;
        String maxStr = "";
        for(int i = 0;i<len;i++){
            for(int j=0;j<len-1-i;j++){
                String str = "";
                if((arr[j]+str+arr[j+1]).compareTo(arr[j+1]+str+arr[j])>0) {
                    swap(arr,j,j+1);
                }
            }

            maxStr = maxStr + arr[len-1-i];
        }

        return maxStr;
    }


    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
