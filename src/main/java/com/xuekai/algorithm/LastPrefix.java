package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/2
 * @Description 最长公共前缀
 *              输入：flore，flizze，flccao
 *              输出：fl
 **/
public class LastPrefix {

    public static void main(String[] args) {
        //String[] arr = {"flore","flizze","flccao"};
        //String[] arr = {"dog","racecar","car"};

        String[] arr = {"ab","a"};
        String result = solution(arr);

        System.out.println(result);

    }

    private static String solution(String[] arr){
        if(arr == null || arr.length == 0){
            return "";
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        Character ch;
        if(arr[0].equals("")){
            return "";
        }else {
            ch = arr[0].charAt(index);
        }


        boolean flag = true;
        while(flag){
            for(String str : arr){
                //弹出条件
                if(index>=str.length()||!ch.equals(str.charAt(index))){
                    flag = false;
                    break;
                }
            }

            if(flag) {
                index++;
                result.append(ch);
                if(index>=arr[0].length()){
                    flag=false;
                }else {
                    ch = arr[0].charAt(index);
                }
            }
        }

        return result.toString();
    }
}
