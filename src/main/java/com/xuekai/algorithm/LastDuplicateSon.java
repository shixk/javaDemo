package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/2/22
 * @Description 最长不重复子串长度
 **/
public class LastDuplicateSon {


    private static int getMaxLength(String s){
        int from =0 , to = 1 , length = 1, maxLength = 1;

        while (to < s.length()){
            // 找到包含重复字符的位置
            int site = s.substring(from,to).indexOf(s.charAt(to));
            //发现包含该字符时
            if(site != -1){
                length = to - from;
                if(length>maxLength){
                    maxLength = length;
                }

                from = from + site +1;
            }
            to++;
        }

        //最后一次
        if(to-from > maxLength){
            maxLength = to - from;
        }

        return maxLength;

    }

    public static void main(String[] args) {

        String s = "qwqrx23riolk";

        int result = getMaxLength(s);

        System.out.println(result);
    }
}
