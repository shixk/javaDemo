package com.xuekai.algorithm.arrays;

/**
 * 将数组元素，组成一个最小的数
 */
public class MinNumber {

    public String solution(int[] arr){
        String result = "";
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                //如果 "ab" > "ba",则 a、b交换
                if(compare(arr[i]+""+arr[j],arr[j]+""+arr[i])){
                    swap(arr,i,j);
                }
            }
        }

        for(int item:arr){
            result += item;
        }

        return result;
    }

    // 13 > 12
    private boolean compare(String s1,String s2){
        boolean flag = false;
        int i=0,j=0;
        while (i<s1.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
                continue;
            }

            return s1.charAt(i)>s2.charAt(j);
        }

        return flag;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        //int[] arr = {6,7,8,12,120};
        int[] arr = {10,2};
        MinNumber instance = new MinNumber();
        String re = instance.solution(arr);

        System.out.println(re);
    }
}
