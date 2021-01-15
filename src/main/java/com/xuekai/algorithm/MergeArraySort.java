package com.xuekai.algorithm;

import java.util.Arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/15
 * @Description 将两个有序数组合并为一个有序数组
 **/
public class MergeArraySort {

    private static int[] mergeAndSort(int[] a,int[] b){
        int[] tempArr = new int[a.length+b.length];

        int i=0,j=0,k=0;

        //分别滑动对比两个数组
        while (i<a.length && j<b.length){
            if(a[i]<b[j]){
                tempArr[k++]=a[i];
                i++;
            }else {
                tempArr[k++]=b[j];
                j++;
            }
        }

        //将较长数组剩余的部分写入结果
        while(i<a.length){
            tempArr[k++]=a[i++];
        }

        //将较长数组剩余的部分写入结果
        while(j<b.length){
            tempArr[k++]=b[j++];
        }

        return tempArr;
    }


    public static void main(String[] args) {
        int[] arr={2,8,34,56,88,90};
        int[] brr={3,6,10,23,78,100,1997};

        int[] re=mergeAndSort(arr,brr);

        System.out.println(Arrays.toString(re));

    }

}
