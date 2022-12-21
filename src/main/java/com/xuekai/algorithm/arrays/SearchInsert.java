package com.xuekai.algorithm.arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 */
public class SearchInsert {

        public int solution(int[] nums,int target){
            int result=nums.length;
            for(int i=0;i<nums.length;i++){
                if(target<=nums[i]){
                    result=i;
                    break;
                }
            }

            return result;
        }

}
