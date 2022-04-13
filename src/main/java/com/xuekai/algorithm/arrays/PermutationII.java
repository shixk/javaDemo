package com.xuekai.algorithm.arrays;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合
 */
public class PermutationII {

    public static void main(String[] args) {
        //int[] candidates = {10,1,2,7,6,1,5};

        int[] candidates={2,5,2,1,2};
        int target=5;
        PermutationII instance = new PermutationII();
        List<List<Integer>> res = instance.solution(candidates,target);

        System.out.println(res);

    }

    public List<List<Integer>> solution(int[] nums,int target){
        Arrays.sort(nums);
        //用set去重复
        HashSet<List<Integer>> res = new HashSet<>();
        dfs(nums,new ArrayList<>(),res,target,0);
        return new ArrayList(res);
    }

    private void dfs(int[] nums,List<Integer> curList,HashSet<List<Integer>> res,int remain,int index){
        if( remain<0){
            return;
        }

        if(remain==0){
            res.add(new ArrayList<>(curList));
            return;
        }

        for(int i = index;i<nums.length;i++){
            //排序后，去除重复数字造成的重复组合
            if(i>index && nums[i] == nums[i-1]) continue;
            curList.add(nums[i]);
            dfs(nums,curList,res,remain-nums[i],i+1);
            curList.remove(curList.size()-1);
        }

    }
}
