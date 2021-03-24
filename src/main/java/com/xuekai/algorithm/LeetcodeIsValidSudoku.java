package com.xuekai.algorithm;

import java.util.HashSet;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/19
 * @Description 是否有效的数独
 **/
public class LeetcodeIsValidSudoku {

    public boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            HashSet<Character> line = new HashSet();
            HashSet<Character> col = new HashSet();
            HashSet<Character> cube = new HashSet();

            for(int j=0;j<9;j++){
                if('.'!=board[i][j]&&!line.add(board[i][j])){
                    return false;
                }

                if('.'!=board[j][i]&&!col.add(board[j][i])){
                    return false;
                }

                int m = i/3*3+j/3;
                int n = i%3*3+j%3;

                if('.'!=board[m][n]&&!cube.add(board[m][n])){
                    return false;
                }
            }
        }

        return true;
    }
}
