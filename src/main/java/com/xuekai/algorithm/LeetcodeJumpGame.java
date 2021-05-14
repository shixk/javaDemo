package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/31
 * @Description 跳跃游戏
 **/
public class LeetcodeJumpGame {


    public static boolean canJump(int[] nums) {

        int len = nums.length;
        int maxLength = 0;
        if(len==1){
            return true;
        }

        for(int i =0;i<len;i++){
            if(i>maxLength){
                return false;
            }
            maxLength = Math.max(maxLength,i+nums[i]);

            if(maxLength>=len-1){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,1,1,4};

        System.out.println(canJump(arr));

        System.out.println(jump(arr));
    }



    private static int jump(int[] nums){
        if(nums.length==1){
            return 1;
        }
        int reach = 0;
        int maxIndex = 0;

        int step =0;

        for(int i=0;i<nums.length;i++){
            maxIndex = Math.max(maxIndex,i+nums[i]);

            if(maxIndex>=nums.length-1){
                return step+1;
            }

            if(i==reach){
                step++;
                reach=maxIndex;
            }
        }

        return step;

    }

}
