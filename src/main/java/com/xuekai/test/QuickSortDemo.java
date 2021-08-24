package com.xuekai.test;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/15
 * @Description
 **/
public class QuickSortDemo {

    public static void main(String[] args) {
        int[] arr = {3,100,8,93,23,46,50,8};

        quickSort(arr,0,arr.length-1);

        for(int i : arr){
            System.out.println(i);
        }

    }

    private static void quickSort(int[] arr,int left,int right){
        if(left>=right){
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

    private static int getPivot(int[] arr,int i, int j){
        int temp = arr[i];
        while (i<j){
            while (i<j && temp<=arr[j]){
                j--;
            }
            arr[i] = arr[j];

            while (i<j && temp>= arr[i]){
                i++;
            }

            arr[j] = arr[i];
        }

        arr[i] = temp;

        return i;
    }


}
