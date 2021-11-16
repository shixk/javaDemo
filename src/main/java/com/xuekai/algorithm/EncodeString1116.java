package com.xuekai.algorithm;

import java.util.Stack;

/**
 * 核心思想就是用两个栈来解决，一个专门存数字的栈，一个专门存储前一段String的栈
 * 遇左括号压入栈，遇右括号分别出栈，在弹出的字符串后面拼接，重复n次的字符串
 */
public class EncodeString1116 {

    public String decodeString(String s){
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int num =0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //数字
            if(c >='0' && c<='9'){
                num = num*10 + (c-'0');
                continue;
            }else if((c>='a' && c<='z')||(c>='A' && c<='Z')) {
                sb.append(c);
                continue;
            }else if(c=='['){
                numStack.push(num);
                strStack.push(sb.toString());
                num = 0;
                sb = new StringBuilder();
                continue;
            }else if(c == ']'){
                int times = numStack.pop();
                //前一段
                StringBuilder preSB = new StringBuilder(strStack.pop());
                for(int j=0;j<times;j++){
                    preSB.append(sb);
                }
                sb = preSB;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        EncodeString1116 entity = new EncodeString1116();
        String s = "abc3[cd]xyz";

        System.out.println(entity.decodeString(s));
    }
}
