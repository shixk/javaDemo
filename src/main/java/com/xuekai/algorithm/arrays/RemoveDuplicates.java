package com.xuekai.algorithm.arrays;

public class RemoveDuplicates {

    public int solution(int[] nums){
        if(nums.length==1){
            return 1;
        }

        int posLast = nums.length-1;
        int i=1;
        while (i<=posLast){
            while (nums[i-1] == nums[i]){
                removeElement(nums,i);
                posLast--;
            }
            i++;
        }

        return posLast+1;
    }

    private void removeElement(int[] nums,int i){
        while(i+1<nums.length){
            swap(nums,i,i+1);
            i++;
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {0,0,1,1,2,3};
        RemoveDuplicates insrance = new RemoveDuplicates();

        System.out.println(insrance.solution(arr));

    }


    /**
     * 标准答案，确实。。。需要思考清楚
     * 只要不相等，就后往前叠加
     *
     * 思路就是：双指针方法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }

            //如果nums[i]==nums[j]那么j停留，i自增后移
        }
        return j+1;
    }
}
