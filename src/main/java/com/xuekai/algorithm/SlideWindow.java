package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/29
 * @Description 滑动窗口相关题目
 **/
public class SlideWindow {

    //有一个数组arr中，求k个连续元素的最大和
    //举例[100,200,300,400] ,当k为2时，最大值是700
    private static int getMaxsumByK(int[] arr,int k){
        int sum=0;
        int size = arr.length;

        //窗口初始大小
        for(int i = 0;i<k;i++){
            sum = sum+arr[i];
        }

        //初始位置
        int index=1;
        while (index+k-1<size){
            int temp = 0;
            for(int i = index;i<=index+k-1;i++){
                temp = temp+arr[i];
            }

            sum = Math.max(sum,temp);
            index++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {100,200,300,400,600};

        int result = getMaxsumByK(arr,4);

        System.out.println(result);

    }
}
