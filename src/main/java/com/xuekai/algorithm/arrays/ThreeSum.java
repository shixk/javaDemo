package com.xuekai.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class ThreeSum {


    public List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        //第一步，先进行从小到大的排序
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i<len;i++){
            if(nums[i]>0){
                continue;
            }
            //如果当前数字，跟前一个数字相同，则跳过
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int L = i+1;
            int R = len-1;
            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]){
                        L++;
                    }

                    while (L<R && nums[R] == nums[R-1]){
                        R--;
                    }

                    L++;
                    R--;
                }else if(sum<0){
                    L++;
                }else{
                    R--;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        ThreeSum model = new  ThreeSum();

        List<List<Integer>> list = model.solution(arr);

        System.out.println(list);

    }
}
