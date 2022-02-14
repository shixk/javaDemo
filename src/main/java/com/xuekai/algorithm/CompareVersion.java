package com.xuekai.algorithm;

public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int length = arr1.length>arr2.length?arr1.length:arr2.length;
        String[] v1 = new String[length];
        String[] v2 = new String[length];


        for(int i =0;i<length;i++){
            if(i<=arr1.length-1) {
                v1[i] = arr1[i];
            }else {
                v1[i] = "0";
            }

            if(i<=arr2.length-1){
                v2[i] = arr2[i];
            }else {
                v2[i] = "0";
            }


            int a1 = Integer.parseInt(v1[i]);
            int a2 = Integer.parseInt(v2[i]);

            if(a1>a2)return 1;
            if(a1<a2) return -1;
        }


        return 0;
    }


    public static void main(String[] args) {

        String s1 = "1.0.1";

        String s2 = "1";

        System.out.println(compareVersion(s1,s2));

    }
}
