package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/4/1
 * @Description 股票买卖一次，获得最大利润
 **/
public class LeetcodeStock {

    private static int solution(int[] nums){
        int max =0 ;
        int min = nums[0];

        for(int i =1;i<nums.length;i++){
            min = Math.min(nums[i],min);

            max = Math.max(nums[i]-min,max);
        }


        return max;
    }


    public static void main(String[] args) {
        int[] arr ={2,3,1,5,7};

        System.out.println(solution(arr));

        int[] arr1 = {7,6,4,3,1};

        System.out.println(solution(arr1));
    }
}
