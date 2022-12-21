package com.xuekai.test;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/3
 * @Description
 **/
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int i=0;
        int j=0;
        int k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                temp[k++] = nums1[i++];
            }else {
                temp[k++] = nums2[j++];
            }
        }

        while (i<m){
            temp[k++] = nums1[i++];
        }

        while (j<n){
            temp[k++] = nums2[j++];
        }

        for(int x=0;x<(m+n);x++){
            nums1[x] = temp[x];
        }
    }


    public static void main(String[] args) {

        String ss = "abc";
        int[] arr={1,2,4,5};
        System.out.println(ss.length());

        System.out.println(arr.length);

    }
}
