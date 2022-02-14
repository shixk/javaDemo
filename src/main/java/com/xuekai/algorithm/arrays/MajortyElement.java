package com.xuekai.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MajortyElement {

    public int solution(int[] nums){

        int n = nums.length;
        int target = n/2;
        Map<Integer,Integer> map = new HashMap<>();
        int element=nums[0];
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                int size = map.get(nums[i])+1;
                map.put(nums[i],size);
                if(size>target){
                    element=nums[i];
                    break;
                }

            }else {
                map.put(nums[i],1);
            }
        }

        return element;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2};
        MajortyElement instance = new MajortyElement();
        System.out.println(instance.solution(arr));

    }
}
