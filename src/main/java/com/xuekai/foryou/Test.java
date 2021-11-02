package com.xuekai.foryou;

import java.util.ArrayList;
import java.util.List;

public class Test {
    // 1，2，3，4
    // 1，2，3｜1，3，2｜2，1，3｜
    public static void main(String[] args) {


    }

    private List<String> solution(int[] arr){
        List<String> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            //i-1

            //i+1

        }

        return list;
    }

    private void processRight(int[] arr, int j){
        while (j<=arr.length-1){
            int temp = arr[j];

        }
    }

    private String getCurrentArray(int[] arr){
        String result = "";
        for(int i=0;i<arr.length;i++){
            result = result+arr[i];
        }

        return result;
    }
}
