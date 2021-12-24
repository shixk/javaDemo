package com.xuekai.algorithm.arrays;

/**
 * 179
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数
 */
public class LargestNumber {

    public String solution(int[] nums){
        //默认数组所有元素均为0
        boolean flag = true;
        for(int i:nums){
            if(i!=0){
                flag = false;
                break;
            }
        }

        String result = "";
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(compare(nums[i]+""+nums[j],nums[j]+""+nums[i])){
                    swap(nums,i,j);
                }
            }
        }

        for(int item:nums){
            result +=item;
        }

        return flag?"0":result;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean compare(String s1,String s2){
        int i=0,j=0;
        while (i<s1.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                continue;
            }

            return s1.charAt(i) < s2.charAt(j);
        }

        return false;
    }

}
