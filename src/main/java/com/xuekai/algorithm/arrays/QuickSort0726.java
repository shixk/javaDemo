package com.xuekai.algorithm.arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/7/26
 * @Description 每日一练
 **/
public class QuickSort0726 {

    public static void main(String[] args) {
        int[] arr = {8,9,3,5,7,10};

        quick_Sort(arr,0,arr.length-1);

        for(int i : arr){
            System.out.println(i);
        }
    }


    public static void quick_Sort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        //寻找枢轴
        int pivot = getPivot(arr,start,end);

        if(start<=pivot-1){
            quick_Sort(arr,start,pivot-1);
        }

        if(pivot+1<=end){
            quick_Sort(arr,pivot+1,end);
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

        arr[i]=temp;

        return i;
    }
}
