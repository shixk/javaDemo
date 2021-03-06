package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/2/24
 * @Description 打印顺时针矩阵
 **/
public class Printmatrix {


    /**
     * 核心就是从外圈向内圈一层一层的打印，每次向内缩一圈
     * 注意：避免重复打印边缘值
     * @param arr
     */
    private static void printHui(int[][] arr){
        //初始左上角位置
        int rowS = 0;
        int colS = 0;

        //初始右下角位置
        int rowEnd = arr.length-1;
        int colEnd = arr[0].length-1;

        while(rowS<rowEnd && colS<colEnd){
            //打印一次外圈
            printEdge(arr,rowS++,colS++,rowEnd--,colEnd--);
        }
    }

    private static void printEdge(int[][] arr ,int rowS,int colS,int rowEnd,int colEnd){
        int curCol = colS;

        //最上边一行
        while (curCol < colEnd){
            System.out.println(arr[rowS][curCol++]);
        }

        //最右边一列
        int curRow = rowS;
        while (curRow < rowEnd){
            System.out.println(arr[curRow++][colEnd]);
        }

        //最下面一行
        while(curCol > colS){
            System.out.println(arr[rowEnd][curCol--]);
        }

        //最左侧一行
        while(curRow > rowS){
            System.out.println(arr[curRow--][colS]);
        }
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1,  2,  3,  4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9,  8,  7}};

        printHui(arr);
    }
}
