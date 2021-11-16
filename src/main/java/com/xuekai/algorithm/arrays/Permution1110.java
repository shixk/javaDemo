package com.xuekai.algorithm.arrays;

/**
 * 数组全排列
 */
public class Permution1110 {

    public void solution(int[] arr,int index){
        if(index == arr.length-1){
            for(int i:arr){
                System.out.print(i);
            }

            System.out.println("");
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            solution(arr,index+1);
            swap(arr,index,i);
        }

    }


    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Permution1110 instance = new Permution1110();
        instance.solution(arr,0);

    }
}
