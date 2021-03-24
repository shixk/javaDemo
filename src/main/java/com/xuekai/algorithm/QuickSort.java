package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/6
 * @Description
 **/
public class QuickSort {

    public static void quickSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        //获取枢轴
        int mid = getMiddle(arr,start,end);

        quickSort(arr,start,mid);
        quickSort(arr,mid+1,end);
    }


    /**
     * 获取枢轴位置的方法
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static int getMiddle(int[] arr, int i, int j) {

        //默认数组第一个值为枢轴
        int temp = arr[i];
        while(i<j){
            //枢轴与最右侧进行对比，逐渐向左进行对比，直至找到比枢轴小的值中断
            while(i<j&& temp<=arr[j]){
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

        int[] arr = {10,8,15,7,88,94,3};

        quickSort(arr,0,arr.length-1);

        for (int v:arr){
            System.out.println(v);
        }
    }

}
