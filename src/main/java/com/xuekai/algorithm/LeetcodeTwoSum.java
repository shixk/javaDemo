package com.xuekai.algorithm;

import java.util.Arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/2/26
 * @Description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标
 **/
public class LeetcodeTwoSum {


    private static int[] twoSum(int[] nums,int target){
        int[] result = {0,0};

        for(int i=0;i<nums.length-1;i++){
            for(int j = i+1;j<=nums.length-1;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr={3,2,4};

        int[] result = twoSum(arr,6);

        System.out.println(result[0]+","+result[1]);
    }
}
