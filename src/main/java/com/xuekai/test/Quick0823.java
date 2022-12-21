package com.xuekai.test;

public class Quick0823 {

    public static void main(String[] args) {
        int[] arr = {88,7,23,90,99,5,5};
        Quick0823 instance = new Quick0823();
        instance.quickSort(arr,0,arr.length-1);

        for(int i:arr){
            System.out.println(i);
        }

    }


    public void quickSort(int[] nums,int left,int right){
        if(left>right){
            return;
        }

        int pivot = getPivot(nums,left,right);
        if(left<pivot-1){
            quickSort(nums,left,pivot-1);
        }

        if(pivot+1<right){
            quickSort(nums,pivot+1,right);
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
        arr[i]=temp;
        return i;
    }
}
