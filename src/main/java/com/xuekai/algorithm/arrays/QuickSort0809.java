package com.xuekai.algorithm.arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/9
 * @Description
 **/
public class QuickSort0809 {

    public static void main(String[] args) {
        int[] arr = {99,12,10,56,8,12,3,76};

        quick_sort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }

    }

    private static void quick_sort(int[] arr , int left , int right){
        if(left>=right){
            return;
        }

        int pivot = getPivot(arr,left,right);

        if(left<pivot-1){
            quick_sort(arr,left,pivot-1);
        }

        if(pivot+1<right){
            quick_sort(arr,pivot+1,right);
        }
    }

    private static int getPivot(int[] arr,int i,int j){
        int temp = arr[i];
        while (i<j){
            while (i<j && temp<=arr[j]){
                j--;
            }

            arr[i] = arr[j];

            while (i<j && temp>=arr[i]){
                i++;
            }

            arr[j] = arr[i];
        }

        arr[i] = temp;

        return i;
    }
}
