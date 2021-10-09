package com.xuekai.entity;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = {98,7,12,90,45,35,7};

        quick_sort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }

    }


    private static void quick_sort(int[] arr,int left, int right){
        if(left>right){
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

            while (i<j && arr[i]<=temp){
                i++;
            }
            arr[j] = arr[i];
        }

        arr[i] = temp;
        return i;
    }
}
