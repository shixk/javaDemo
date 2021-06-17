package com.xuekai.algorithm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/24
 * @Description 生成有效的括号对
 *              输入：3
 *              输出：["()()()",
 *                    "(()())","()(())","(())()",
 *                    "((()))"]
 **/
public class LeetcodeGeneratebrackets {

    public static List<String> generateParenthesis(int n) {
        List<String> result = Lists.newArrayList();

        generateList("",result,n,n);
        return result;
    }


    private static void  generateList(String subStr,List<String> result,int left,int right){
        if(left==0&&right==0){
            result.add(subStr);
            return;
        }

        if(left>0){
            generateList(subStr+"(",result,left-1,right);
        }

        if(right>left){
            generateList(subStr+")",result,left,right-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        List<String> result = generateParenthesis(n);

        System.out.println(result);
    }
}
