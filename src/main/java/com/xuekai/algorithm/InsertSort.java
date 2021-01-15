package com.xuekai.algorithm;

import java.util.Arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/1/13
 * @Description 直接插入排序
 **/
public class InsertSort {

    //目标是排成一个从小到大的有序数组
    //从第二个元素开始，向右移动
    //第i个元素跟前边的有序数组对比，如果比前n个元素都小，那么这n个元素都向后移动，直到找到前一个比他大的位置插入

    public static void straightInsertionSort(int[] a) {
        int temp=0;
        for(int i =1 ;i<a.length;i++){
            temp=a[i];
            for(int j=i-1;j>=0;j--){
                if(a[j]>temp){
                    a[j+1]=a[j];
                    if(j==0){
                        a[0]=temp;
                    }
                }else {
                    a[j+1]=temp;
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        //int[] arr = {3,40,12,5,23,88};
        int[] arr = new int[]{3,40,12,5,23,8};
        straightInsertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
