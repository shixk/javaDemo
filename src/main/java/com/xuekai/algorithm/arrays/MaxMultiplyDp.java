package com.xuekai.algorithm.arrays;

/**
 * 最大连续子序列乘积
 */
public class MaxMultiplyDp {

    public int solution(int[] nums){
        int max = nums[0];
        int preMax = nums[0],preMin = nums[0];

        for(int i=1;i<nums.length;i++){
            int maxVal = Math.max(preMax*nums[i],Math.max(preMin*nums[i],nums[i]));
            int minVal = Math.min(preMin*nums[i],Math.min(preMax*nums[i],nums[i]));
            preMax = maxVal;
            preMin = minVal;
            max = Math.max(preMax,max);
        }

        return max;
    }

    public static void main(String[] args) {
        //int[] nums = {10,2,3,0,5,9,100};
        int[] nums = {-4,-3,-2};
        MaxMultiplyDp instance = new MaxMultiplyDp();

        System.out.println(instance.solution(nums));
    }
}
