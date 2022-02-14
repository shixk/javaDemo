package com.xuekai.algorithm.arrays;

/**
 * 消失的第一个正数
 *
 * 核心思路就是：数字i，应该在数组i-1的位置上出现
 *           如果 arr[i]!= arr[arr[i]-1],那么 swap(arr[i],arr[arr[i]-1]
 * 给定一个数组[1，2，0] 输出3
 * 输入[1,3,4,-1] 输出2
 */
public class FirstMissPositive {

    public int solution(int[] nums){
        for(int i=0;i<nums.length;i++){
            //这里注意，需要持续替换，直到被替换的元素，不符合条件为止
            while (nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[nums[i]-1]){
                //swap
                int j = nums[i]-1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return nums.length+1;
    }

    public static void main(String[] args) {
        int[] arr = {1};
        FirstMissPositive instance = new FirstMissPositive();
        System.out.println(instance.solution(arr));
    }
}
