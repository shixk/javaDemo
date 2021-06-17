package com.xuekai.algorithm.arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/9
 * @Description 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 *              一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 *              你可以假设网格的四个边均被水包围
 **/
public class IslandCount {

    /**
     * 思路：深度遍历，当遇到'1'时，则将它相连的前后左右相连的'1'都设置为'0',这块陆地+1
     * @param arr
     * @return
     */
    public int solution(char[][] arr){
        int cnt = 0;

        for(int i =0 ;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j]=='1'){
                    depthSearch(arr,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void depthSearch(char[][] arr,int i,int j){
        if( i<0 || i>=arr.length || j<0 || j>=arr[i].length){
            return;
        }

        if(arr[i][j] == '0'){
            return;
        }

        arr[i][j] = '0';
        depthSearch(arr,i+1,j);
        depthSearch(arr,i-1,j);
        depthSearch(arr,i,j+1);
        depthSearch(arr,i,j-1);
    }


    public static void main(String[] args) {
        char[][] arr = new char[4][5];

        char[] item0 = {'1','1','1','1','0'};
        char[] item1 = {'1','1','0','1','0'};
        char[] item2 = {'1','1','0','0','0'};
        char[] item3 = {'0','0','0','0','1'};
        arr[0] = item0;
        arr[1] = item1;
        arr[2] = item2;
        arr[3] = item3;

        IslandCount clz = new IslandCount();

        System.out.println(clz.solution(arr));
    }
}
