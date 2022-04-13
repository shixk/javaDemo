package com.xuekai.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Combine {


    public void solution(int[] nums,List<List<Integer>> res,int index){
        if(index == nums.length){
            List result = Lists.newArrayList();
            for(Integer item:nums){
                result.add(item);
            }
            res.add(result);
            return;
        }

        for(int i =index;i<nums.length;i++){
            swap(nums,i,index);
            solution(nums,res,index+1);
            swap(nums,index,i);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums={2,3,5};
        List<List<Integer>> res = new ArrayList<>();

        Combine instance = new Combine();
        instance.solution(nums,res,0);

        System.out.println(res);

    }
}
