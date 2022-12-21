package com.xuekai.test;

public class QuickSort1208 {


    public static void main(String[] args) {
        int[] arr = {33,99,6,8,1,7,7,2};
        quick_sort(arr,0,arr.length-1);

        for(int i:arr){
            System.out.println(i);
        }

    }

    private static void quick_sort(int[] arr,int left,int rignt){
        if(left>rignt){
            return;
        }

        int pivot = getPivot(arr,left,rignt);

        if(left<pivot-1){
            quick_sort(arr,left,pivot-1);
        }

        if(pivot+1<rignt){
            quick_sort(arr,pivot+1,rignt);
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
