package com.xuekai.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针螺旋打印二维数组
 * [1,2,3]
 * [8,9,4]
 * [7,6,5]
 * 输出：（1,2,3,4,5,6,7,8,9)
 * 思路:就是从外圈向内圈，一圈一圈打印四个边，注意边界值即可
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0]=new int[]{7,9,6};
        arr[1]=new int[]{1,2,3};
        arr[2]=new int[]{4,5,8};
        SpiralOrder instance = new SpiralOrder();

        List<Integer> list = instance.spiralOrder(arr);

        System.out.println(list);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //右下角的坐标
        int rowIndex = matrix.length-1;
        int colIndex = matrix[0].length-1;

        int i=0,j=0;
        while (i<=rowIndex&&j<=colIndex){
            printRange(matrix,i++,j++,rowIndex--,colIndex--,list);
        }

        return list;
    }


    private void printRange(int[][]arr,int rowStart,int colStart,int rowEnd,int colEnd,List<Integer> list){
        int i=rowStart;
        int j=colStart;
        //打印上边
        while(j<=colEnd && j>=colStart){
            list.add(arr[i][j]);
            j++;
        }
        j--;
        i++;

        if(rowEnd>rowStart) {
            //打印右侧边
            while (i <= rowEnd) {
                list.add(arr[i][j]);
                i++;
            }
            i--;
            j--;
        }
        if(colEnd>colStart && rowEnd>rowStart) {
            //打印下边
            while (j >= colStart) {
                list.add(arr[i][j]);
                j--;
            }
            j++;
            i--;
        }

        //避免只有一列
        if(colEnd>colStart) {
            //打印左侧边
            while (i > rowStart && i <= rowEnd) {
                list.add(arr[i][j]);
                i--;
            }
        }
    }
}
