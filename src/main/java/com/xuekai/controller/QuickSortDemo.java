package com.xuekai.controller;

/**
 * 快速排序算法
 * 
 * @author shixk1
 *
 */
public class QuickSortDemo {
	public static void main(String[] args) {
		int[] arr={12,5,35,67,213,43,75,38};
		quick_sort(arr,0,arr.length-1);
		
		String a="";
		for(int i:arr){
			a=a+String.valueOf(i)+",";
		}
		
		System.out.println(a);
	}

	/**
	 * 
	 * @param arr
	 *            目标数组
	 * @param start
	 *            开始位置
	 * @param end
	 *            结束位置
	 */
	public static void quick_sort(int arr[], int start, int end) {
		if (start > end) {
			//System.out.println("初始位置大于结束位置，搞不了！");
			return;
		}
		
		int mid=getMiddle(arr,start,end);//获取中间枢轴的位置，将数组一分为2
		if(start-mid>1){
			quick_sort(arr,start,mid-1);//枢轴左侧递归
		}
		if(end-mid>1){
			quick_sort(arr,mid+1,end);//枢轴 右侧递归
		}
		
	}

	private static int getMiddle(int[] arr, int start, int end) {

		//{12,5,35,67,213,43,75,38};
		//{12,5,35,38,213,43,75,38};
		//{12,5,35,38,213,43,75,213};
		int temp=arr[start];
		while(start<end){
			while(start<end&&temp<arr[end]){
				end--;
			}
			arr[start]=arr[end];
			while(start<end&&temp>arr[start]){
				start++;
			}
			if(start<end){
				arr[end]=arr[start];
			}
		}
		arr[start]=temp;
		return start;
	}
}
