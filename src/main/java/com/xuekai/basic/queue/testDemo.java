package com.xuekai.basic.queue;

import com.xuekai.entity.People;
import com.xuekai.entity.Student;
import com.xuekai.enums.NameAndClassPairEnum;
import com.xuekai.utils.JsonTool;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/25
 * @Description
 **/
public class testDemo {


    public static void main(String[] args) {
        int[] arrr={1,2,3,4,5,6};


        System.out.println(search(arrr,0,6,3));

    }

     static  int  search(int[] nums, int low, int high, int value) {
         if(nums == null || nums.length==0){
             return -1;
         }

         while(low<high){
             int media = (high-low)/2;
             if(nums[media] == value){
                 return media;
             }
             if(value < nums[media]){
                 high = media-1;
             }else{
                 low=media+1;
             }
         }
         return -1;
     }
}
