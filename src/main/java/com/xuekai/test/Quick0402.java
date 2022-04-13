package com.xuekai.test;

public class Quick0402 {

    public static void main(String[] args) {
        int[] arr = {3,8,5,90,42,77,100,77};
        Quick0402 instance = new Quick0402();
        instance.quickSort(arr,0,arr.length-1);

        for(int item:arr){
            System.out.println(item);
        }

    }

    public void quickSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }

        int pivot = getPivot(arr,left,right);

        if(left<pivot-1){
            quickSort(arr,left,pivot-1);
        }

        if(pivot+1<right){
            quickSort(arr,pivot+1,right);
        }

    }

    private int getPivot(int[] arr,int i,int j){
        int temp = arr[i];
        while(i<j){
            while (i<j && temp<=arr[j]){
                j--;
            }

            arr[i]=arr[j];

            while (i<j && temp>=arr[i]){
                i++;
            }

            arr[j] = arr[i];
        }
        arr[i]=temp;
        return i;
    }

}
