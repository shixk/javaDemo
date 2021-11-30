package com.xuekai.test;

public class QuickSort1123 {

    public static void main(String[] args) {
        int[] arr = {100,73,9,12,35,12,4,99};

        solution(arr,0,arr.length-1);

        for(int item:arr){
            System.out.println(item);
        }
    }

    private static void solution(int[] arr,int left,int right){
        if(left>right){
            return;
        }

        int pivot = getPivot(arr,left,right);

        if(left<pivot-1){
            solution(arr,left,pivot-1);
        }

        if(pivot+1<right){
            solution(arr,pivot+1,right);
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
