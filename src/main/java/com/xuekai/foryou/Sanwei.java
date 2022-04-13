package com.xuekai.foryou;

public class Sanwei {

    public static void main(String[] args) {
        //int[][][] data = new int[3][3][3];
        int[] arr = {5,7,9,4,99,8};

        Sanwei instance = new Sanwei();

        System.out.println(instance.solution(arr,2));

    }

    public int solution(int[] arr,int k){
        Sanwei instance = new Sanwei();
        instance.quickSort(arr,0,arr.length-1,k);

        return arr[arr.length-k];
    }

    public void quickSort(int[] arr,int left,int right,int k){
        if(left>right){
            return;
        }
        int pivot = getPivot(arr,left,right);

        //左侧[0,length-k-1]，右侧[length-k-1,length-1]

        if(left<pivot-1){
            if(pivot<=arr.length-k-1) {
                quickSort(arr, arr.length-k-1, pivot - 1,k);
            }
        }

        if(pivot+1<right){
            quickSort(arr,pivot+1,right,k);
        }

    }


    private int getPivot(int[] arr,int i,int j){
        int temp = arr[i];
        while (i<j){
            while (i<j && temp<=arr[j]){
                j--;
            }
            arr[i] = arr[j];
            while (i<j && temp>=arr[i]) {
                i++;
            }
            arr[j]=arr[i];
        }

        arr[i] = temp;

        return i;
    }



}
