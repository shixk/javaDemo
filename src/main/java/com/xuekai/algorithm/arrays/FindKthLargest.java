package com.xuekai.algorithm.arrays;

public class FindKthLargest {

    public int solution(int[] arr,int k){
        quick_sort(arr,0,arr.length-1);
        int result=-1;
        int index=0;
        for(int i=arr.length-1;i>=0;i--){
            index++;
            if(index == k){
                result = arr[i];
                break;
            }
        }

        return result;
    }

    private void quick_sort(int[] arr,int left,int right){
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

    private int getPivot(int[] arr,int i, int j){
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
