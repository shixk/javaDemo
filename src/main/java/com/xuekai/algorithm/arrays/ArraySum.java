package com.xuekai.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class ArraySum {


    public List<List<Integer>> solution(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        combine(res,nums,target,0,new ArrayList<>());
        return res;
    }

    private void combine(List<List<Integer>> res,int[] nums,int remain,int index,List<Integer> list){
        if(remain<0) return;
        else if(remain == 0){
            res.add(new ArrayList<>(list));
            return;
        }else {
            for(int i=index;i< nums.length;i++){
                list.add(nums[i]);
                combine(res,nums,remain-nums[i],i,list);
                list.remove(list.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr={2,3,5};
        ArraySum instance = new ArraySum();
        List<List<Integer>> res = instance.solution(arr,8);

        System.out.println(res);

    }



}
