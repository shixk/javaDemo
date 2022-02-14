package com.xuekai.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * 输入:arr[2,3,5] ,target=8
 * 输出:[[2,2,2,2],[2,3,3],[2,3,5]]
 *
 */
public class Candidate {

    public static void main(String[] args) {
        int[] arr={2,3,5};
        Candidate instance = new Candidate();

        List<List<Integer>> res = instance.solution(arr,8);

        System.out.println(res);

    }

    public List<List<Integer>> solution(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        combineDfs(res,nums,target,new ArrayList<>(),0);
        return res;
    }


    private void combineDfs(List<List<Integer>> res,int[] nums,int remain,List<Integer> list,int index){
        if(remain<0) return;
        else if(remain == 0){
            res.add(new ArrayList<>(list));
            return;
        }else {
            for(int i=index;i<nums.length;i++){
                list.add(nums[i]);
                combineDfs(res,nums,remain-nums[i],list,i);
                list.remove(list.size()-1);
            }
        }
    }
}
