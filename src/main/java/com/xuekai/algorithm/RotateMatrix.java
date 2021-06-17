package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/25
 * @Description 选择矩阵，顺时针选择90°
 *              解法1：利用一个新的克隆矩阵，然后按照公式a[y][n-1-x]=a[x][y] 填充即可
 *              解法2：先按照斜的中心轴，做数据交换，然后再按照横的中心轴做数据交换即可
 **/
public class RotateMatrix {

    /**
     * 采用解法2
     * @param a
     */
    public static void solution2(int[][] a){
        int n = a.length;

        if(n==1){
            return;
        }

        //从左下角位置起始
        int x = n-1;
        int y = 0;
        //循环n次
        for(int i =0;i<n;i++){
            //沿斜轴交换
            int r = x;
            int c = y;
            while(r>0&&c<n-1){
                swap(a,--r,y,x,++c);
            }
            x--;
            y++;
        }

        int up,down=0;
        //奇数
        if((n-1)%2==0){
            up=(n-1)/2-1;
            down=(n-1)/2+1;
        }
        //偶数
        else{
            up=(n-1)/2;
            down=(n-1)/2+1;
        }

        //上下对称交互
        for(int i=0;i<n;i++){
            int upTemp=up;
            int dowmTemp=down;
            while(upTemp>=0&&dowmTemp<=n){
                swap(a,upTemp,i,dowmTemp,i);
                upTemp--;
                dowmTemp++;
            }
        }

    }

    private static void swap(int[][] a,int x, int y, int i, int j){
        int temp = a[x][y];
        a[x][y]=a[i][j];
        a[i][j]=temp;
    }

    public static void main(String[] args) {
        int[][] arr=new int[3][3];
        arr[0]=new int[]{1,2,3};
        arr[1]=new int[]{4,5,6};
        arr[2]=new int[]{7,8,9};

        solution2(arr);

        System.out.println(arr);
    }


}
