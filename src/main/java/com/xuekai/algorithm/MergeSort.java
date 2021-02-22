package com.xuekai.algorithm;

import java.util.Arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/23
 * @Description 归并排序
 **/
public class MergeSort {

    private static void sort(int[] arrSource){
        int[] temp = new int[arrSource.length];
        mergeSort(arrSource,temp,0,arrSource.length-1);
    }

    private static void mergeSort(int[] arr,int[] temp,int left,int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,temp,0,mid);
            mergeSort(arr,temp,mid+1,right);
            merge(arr,temp,left,mid,right);
        }
    }

    private static void merge(int[] a,int[] temp,int leftpos,int mid,int right){
        int i=leftpos;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=right){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        //拷贝剩余元素
        while (i<=mid){
            temp[k++] = a[i++];
        }

        while (j<=right){
            temp[k++] = a[j++];
        }

        //将本次排序后的两个对比范围的数据，拷贝到原数组
        k=0;
        while (leftpos<=right){
            a[leftpos++] = temp[k++];
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{12,56,22,100,67};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
