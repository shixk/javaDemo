package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/6
 * @Description
 **/
public class QuickSort {

    public static void quickSort(int[] arr){
        int length = arr.length;

        int mid = length/2;

        sort(arr,0,mid);
        sort(arr,mid+1,length-1);
    }

    private static void sort(int[] arr,int left,int right){
        while(left<right){
            if(arr[left]>arr[right]){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            left++;
        }

        while (left>right){

        }
    }
}
