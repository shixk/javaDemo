package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/25
 * @Description 接雨水
 *              输入：[0,1,0,2,1,0,1,3,2,1,2,1]
 *              输出：6
 *
 *              核心思路是找到每个元素的左侧最高高度lmax，和右侧最高高度rmax，比较得出较低一边hmax=min(lmax,rmax)
 *              那么该元素可以盛水量ans = hmax-height[i];
 *              累加所有元素ans即可
 **/
public class LeetcodeReceiveRain {


    private static int solution(int[] nums){
        int result = 0;

        //收尾的两个元素没有必要去计算了，所以减少2个计算
        int[] l_max = new int[nums.length];
        l_max[0] = nums[0];
        int[] r_max = new int[nums.length];
        r_max[nums.length-1] = nums[nums.length-1];

        //从左往右找出每个元素对应的最高值，存入l_max数组
        for(int i =1;i<nums.length;i++){
            l_max[i] = Math.max(nums[i],l_max[i-1]);
        }

        //从右往左找出每个元素对应的右侧最高值，存储r_max数组
        for(int j=nums.length-2;j>=0;j--){
            r_max[j] = Math.max(nums[j],r_max[j+1]);
        }

        for(int i =1;i<nums.length;i++){
            result+=Math.min(l_max[i],r_max[i])-nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,2,1,0,1,3,2,1,2,1};

        int ans = solution(nums);

        System.out.println(ans);

        int[] nums1 = {1};

        int ans1=solution(nums1);

        System.out.println(ans1);
    }
}
