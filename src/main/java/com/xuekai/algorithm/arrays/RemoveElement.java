package com.xuekai.algorithm.arrays;

/**
 * 删除元素，并返回最新的数组长度
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 */
public class RemoveElement {

    /**
     * 使用快慢指针
     * @param nums
     * @param val
     * @return
     */
    public int solution(int[] nums,int val){
        int slow = 0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] arr={1,2,2,2,3,2,4};
        RemoveElement instance = new RemoveElement();
        int a = instance.solution(arr,2);
        System.out.println(a);
    }
}
