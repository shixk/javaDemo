package com.xuekai.algorithm.arrays;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/31
 * @Description 旋转数组
 *           输入: nums = [1,2,3,4,5,6,7], k = 3
             输出: [5,6,7,1,2,3,4]
 **/
public class RotateArray {

    public void  solution(int[] nums,int k){
        int n = k%nums.length;

        for(int i = 0;i<n;i++){
            singleExecute(nums);
        }

    }


    private void singleExecute(int[] arr){
        int length = arr.length;
        int last = arr[length-1];
        for(int j=length-1;j>0;j--){
            arr[j]=arr[j-1];
        }

        //最后的那个尾部元素被覆盖了，所以补充到头结点
        arr[0]=last;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        RotateArray clz = new RotateArray();

        //clz.solution(arr,3);

        clz.solution2(arr,3);
        System.out.println(arr);

    }


    /**
     *
     * @param nums
     * @param k
     * 方案：将数组nums分成n-k和k两段数据，然后分别倒置两段数据，然后再将整个数组倒置，就是输出结果了
     *
     */
    public void solution2(int[] nums,int k){
        int n = nums.length;
        k = k%n;

        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }

    private void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
