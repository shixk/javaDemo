package com.xuekai.algorithm.arrays;

/**
 * 二分查找
 * 题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 *      写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 */
public class HalfSearch {


    public int search(int[] nums,int target){
        int i=0;
        int j=nums.length-1;

        int re = -1;
        while (i<=j){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                re = mid;
                break;
            }

            if(target > nums[mid]){
                i = mid +1;
                continue;
            }

            if(target < nums[mid]){
                j = mid-1;
                continue;
            }
        }

        return  re;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,8,10,52,78};
        HalfSearch instance = new HalfSearch();
        int re = instance.search(arr,33);
        System.out.println(re);
    }
}
