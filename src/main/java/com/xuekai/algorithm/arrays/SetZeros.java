package com.xuekai.algorithm.arrays;

/**
 * 矩阵置0
 * m*n的二维矩阵中，如果发现某个位置元素是0，则把该位置所在行和列都置为0
 */
public class SetZeros {

    //思路：即利用第一行与第一列作为空间介质，把变量数组剩余的位置，如果发现某个元素为0，则将其所在行和列位置
    //记录到第一行a[0][j] = 0,第一列a[i][0]=0的位置上
    //第一行与第一列是否需要置为0，需要单独判断，存储两个变量即可
    public void solution(int[][] matrix){
        int col = matrix[0].length;
        int row = matrix.length;

        Boolean colFlag = false, rowFlag = false;
        //第一行是否包含0
        for(int i=0;i<col;i++){
            if(matrix[0][i] == 0){
                rowFlag = true;
                break;
            }
        }
        //第一列是否包含0
        for(int i=0;i<row;i++){
            if(matrix[i][0] == 0){
                colFlag = true;
            }
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //遍历第一行,index从1开始～
        for(int j=1;j<col;j++){
            if(matrix[0][j] == 0){
                for(int i=1;i<row;i++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=1;i<row;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<col;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(rowFlag){
            for (int j=0;j<col;j++){
                matrix[0][j] = 0;
            }
        }

        if(colFlag){
            for(int i=0;i<row;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
