package com.xuekai.test.model;

public class QucikSort {


    public static void main(String[] args) {
        int[] arr = {3,6,90,81,7};

        qucik_sort(arr,0,arr.length-1);

        for(int i : arr){
            System.out.println(i);
        }
    }

    private static void qucik_sort(int[] arr,int left,int rigtht){
        if(left>rigtht){
            return;
        }

        int pivot = getPivot(arr,left,rigtht);
        if(left<pivot-1){
            qucik_sort(arr,left,pivot-1);
        }

        if(pivot+1<rigtht){
            qucik_sort(arr,pivot+1,rigtht);
        }
    }

    private static int getPivot(int[] arr,int i, int j){
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
