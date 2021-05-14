package com.xuekai.test;

import java.util.Arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/4/20
 * @Description
 **/
public class Txtest {
//    题目描述给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
//    使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//    注意:不能使用代码库中的排序函数来解决这道题。样例输入[2,0,2,1,1,0]输出 [0,0,1,1,2,2]


    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,3,0,0,1,2};

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }


    private static void quickSort(int[] arr,int left,int right){
        if(left>right){
            return;
        }

        int mid = getPivot(arr,left,right);

        if(left<mid-1) {
            quickSort(arr, left, mid - 1);
        }
        if(mid+1<right) {
            quickSort(arr, mid + 1, right);
        }
    }


    private static int getPivot(int[] arr,int left,int right){
        int i = left;
        int j = right;
        int temp = arr[i];
        while (i<j){
            while (i<j && arr[j]>=temp){
                j--;
            }
            arr[i] = arr[j];

            while (i<j && arr[i]<=temp){
                i++;
            }

            arr[j] = arr[i];

        }

        arr[i] = temp;
        return i;
    }


}
