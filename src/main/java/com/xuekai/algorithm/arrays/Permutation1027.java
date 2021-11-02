package com.xuekai.algorithm.arrays;

public class Permutation1027 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6};

        Permutation1027 model = new Permutation1027();

        model.solution(arr,0);
    }


    public void solution(int[] arr,int index){
        //终止条件，弹出
        if(index == arr.length-1){
            for(int item:arr){
                System.out.print(item);
            }
            System.out.println(" ");
            return;
        }

        for(int i = index;i<arr.length;i++){
            swap(arr,index,i);
            solution(arr,index+1);
            swap(arr,i,index);
        }
    }

    private void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
