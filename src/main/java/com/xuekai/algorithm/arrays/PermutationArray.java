package com.xuekai.algorithm.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组全排列
 */
public class PermutationArray {



    public List<List<Integer>> permutate(int[] arr){
        List<List<Integer>> res = new ArrayList<>();

        solution(arr,res,0);
        return res;
    }


    public void solution(int[] arr,List<List<Integer>> res,int start){

        if(start==arr.length-1){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            res.add(list);
            return;
        }

        for(int i=start;i<arr.length;i++){
            swap(arr,start,i);
            solution(arr,res,start+1);
            swap(arr,i,start);
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr={1,2,3};
        PermutationArray method = new PermutationArray();


        List<List<Integer>> res = method.permutate(arr);

        System.out.println(res);


        method.findNextNums(arr);

        System.out.println(arr);

    }


    //实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
    //
    //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    //
    //必须 原地 修改，只允许使用额外常数空间。
    //

    private void findNextNums(int[] nums){
        //如果当前数组就是最大数字
        if(isBiggestNum(nums)){
            //则返回逆序数组
            reverse(nums);
        }else {
            swap(nums,nums.length-2,nums.length-1);
        }
    }

    private boolean isBiggestNum(int[] nums){
        boolean flag = true;
        for(int j=nums.length-1;j>1;j--){
            if(nums[j]<=nums[j-1]){
                continue;
            }

            flag = false;
        }

        return flag;
    }

    private void reverse(int[] nums){
        int i = 0;
        int j = nums.length-1;

        while (i<j){
            swap(nums,i,j);
        }
    }


}
