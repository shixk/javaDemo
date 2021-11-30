package com.xuekai.controller;

public class AAA {

    public String solution(int[] arr){
        String result="";

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int a = arr[i];//12
                int b = arr[j];//120
                if(Integer.parseInt(a+""+b) > Integer.parseInt(b+""+a)){
                    swap(arr,i,j);
                }
            }
        }

        for(int item:arr){
            result = result + item;
        }

        return result;
    }

    private boolean compare(String s1, String s2){
        int i;
        int j;

        return false;
    }


    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void main(String[] args) {
        //int[] arr = {6,7,8,12,120};
        int[] arr = {6,7,8,12,125};
        AAA instance = new AAA();
        String re = instance.solution(arr);

        System.out.println(re);
    }

}
