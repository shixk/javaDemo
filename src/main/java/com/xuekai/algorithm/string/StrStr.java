package com.xuekai.algorithm.string;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1
 * 当 needle 是空字符串时，我们应当返回什么值呢？
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0
 */
public class StrStr {

    public int solution(String haystack, String needle){
        if(needle.equals("")){
            return 0;
        }
        int result = -1;
        int size = needle.length();
        for(int i=0;i<haystack.length();i++){
            int end = i+size;
            if(end > haystack.length()){
                break;
            }

            String s1 = haystack.substring(i,end);
            if(compare(s1,needle)){
                result = i;
                break;
            }
        }

        return result;
    }

    private boolean compare(String s1,String s2){
        int i=0;
        int j=s1.length()-1;
        while (i<=j){
            if(s1.charAt(i)==s2.charAt(i) && s1.charAt(j)==s2.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String source = "abc";
        String needle = "c";

        System.out.println(new StrStr().solution(source,needle));
    }
}
