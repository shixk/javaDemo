package com.xuekai.algorithm;

import java.util.Stack;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/10
 * @Description 判断有效的括号
 *              给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 **/
public class LeetcodeEffectivebrackets {


    public static void main(String[] args) {
        String s1 = "{}(";
        String s2 = "()()";

        String s3 = "]";

        System.out.println(isEffective(s1));
        System.out.println(isEffective(s2));
        System.out.println(isEffective(s3));
    }


    private static Boolean isEffective(String str){
        Stack<Character> stack = new Stack();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='{'||c=='['||c=='('){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char topC = stack.pop();

                if(c=='}'&&topC!='{'){
                    return false;
                }else if(c==']'&&topC!='['){
                    return false;
                }else if(c==')'&&topC!='('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
