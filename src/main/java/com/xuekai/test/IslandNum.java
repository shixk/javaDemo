package com.xuekai.test;

/**
 * 岛屿数量问题
 */
public class IslandNum {

    public static void main(String[] args) {
        int[][] grid = new int[4][5];
        grid[0]=new int[]{1,1,0,0,0};
        grid[1]=new int[]{1,0,1,0,0};
        grid[2]=new int[]{1,0,0,0,1};
        grid[3]=new int[]{1,0,0,1,1};

        IslandNum instance = new IslandNum();
        System.out.println(instance.solution(grid));
    }


    public int solution(int[][] grid){
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;
    }


    private void dfs(int[][] arr,int i,int j){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length){
            return;
        }

        if(arr[i][j]==0){
            return;
        }

        arr[i][j]=0;
        dfs(arr,i-1,j);
        dfs(arr,i+1,j);
        dfs(arr,i,j-1);
        dfs(arr,i,j+1);
    }
}
