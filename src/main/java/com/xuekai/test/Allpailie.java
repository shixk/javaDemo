package com.xuekai.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Allpailie {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        Allpailie instance = new Allpailie();

        instance.solution(arr,0,result);

        System.out.println(result);

    }

    public void solution(int[] arr,int index,List<List<Integer>> res){
        if(index == arr.length-1){
            List<Integer> listTemp = new ArrayList<>();
            for(int item:arr){
                listTemp.add(item);
            }
            res.add(listTemp);
            return;
        }

        for(int i=index;i<arr.length;i++){
            swap(arr,i,index);
            solution(arr,index+1,res);
            swap(arr,index,i);
        }
    }


    private void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
