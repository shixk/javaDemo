package com.xuekai.algorithm.arrays;

public class QuickSort1213 {

    public static void main(String[] args) {
        int[] arr = {3,6,0,12,2,66,49,6};
        QuickSort1213 instance = new QuickSort1213();
        instance.quick_sort(arr,0,arr.length-1);

        for (int item:arr){
            System.out.println(item);
        }

    }

    public void quick_sort(int[] arr,int left,int right){
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

    private int getPivot(int[] arr,int i,int j){
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
