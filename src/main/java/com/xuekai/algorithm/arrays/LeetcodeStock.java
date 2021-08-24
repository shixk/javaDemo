package com.xuekai.algorithm.arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/5
 * @Description 买卖股票
 **/
public class LeetcodeStock {

    public static void main(String[] args) {
        int[] arr = {8,10,4,100,97};

        int result = solution(arr);

        System.out.println(result);
    }

    private static int solution(int[] arr){
        int max = arr[0];
        int min = arr[0];

        for (int item : arr){
            min = Math.min(item,min);
            max = Math.max(item,max);
        }

        return max-min;
    }
}
