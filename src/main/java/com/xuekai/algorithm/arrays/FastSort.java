package com.xuekai.algorithm.arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/7
 * @Description 每日一练：快排
 **/
public class FastSort {

    public void quick_sort(int[] arr,int left, int right){
        if(left>=right){
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


    private int getPivot(int[] arr, int i, int j){
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


    public static void main(String[] args) {
        int[] arr = {8,3,6,1,12,3};

        FastSort fastSort = new FastSort();

        fastSort.quick_sort(arr,0,arr.length-1);

        System.out.println(arr);
    }
}
