package com.xuekai.algorithm.string;

/**
 * 字符串相加
 */
public class AddString {

    public String solution(String s1,String s2){

        String strA = reverseStr(s1);
        String strB = reverseStr(s2);

        int pos = 0;
        String result = "";
        int i = 0;
        while (i<strA.length() && i<strB.length()){
            int a =0,b=0;
            if(i<strA.length()) {
                a = strA.charAt(i) - '0';
            }
            if(i<strB.length()) {
                b = strB.charAt(i) - '0';
            }

            int sum = a+b+pos;
            pos = sum/10;
            result = result+sum%10;

            i++;
        }

        //如果A串还有剩余字符
        while (i<strA.length()){
            int m = strA.charAt(i) - '0';
            result = result + (m+pos)%10;
            pos = (m+pos)/10;
            i++;
        }

        while (i<strB.length()){
            int m = strB.charAt(i) - '0';
            result = result + (m+pos)%10;
            pos = (m+pos)/10;
            i++;
        }

        if(pos>0){
            result = result + pos;
        }

        return reverseStr(result);
    }


    private String reverseStr(String s){
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length()-1;

        while (i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }


    public static void main(String[] args) {
        String s1 = "456";
        String s2 = "77";
        AddString instance = new AddString();

        System.out.println(instance.solution(s1,s2));

    }
}
