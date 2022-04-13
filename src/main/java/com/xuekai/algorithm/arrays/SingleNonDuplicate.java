package com.xuekai.algorithm.arrays;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次
public class SingleNonDuplicate {

    public int solution(int[] nums){
        int i=0;
        while(i<nums.length){
            // 已经遍历到了最后一个元素
            if(i == nums.length-1){
                return nums[i];
            }
            //下一个位置
            int j=i +1;
            if(nums[i] == nums[j]){
                i = j+1;
                continue;
            }else{
                return nums[i];
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        //int[] arr={1,1,2,3,3};
        int[] arr={1,2,2};
        SingleNonDuplicate instance = new SingleNonDuplicate();
        System.out.println(instance.solution(arr));

    }
}
