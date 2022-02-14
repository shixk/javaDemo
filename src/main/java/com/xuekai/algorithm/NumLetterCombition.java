package com.xuekai.algorithm;

import java.util.ArrayList;
import java.util.List;
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
public class NumLetterCombition {

    public List<String> solution(String str){
        String[] alphabet = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> soureList = new ArrayList<>();
        if(str.equals("")){
            return soureList;
        }
        //找到数字对应的字符串
        for(int i=0;i<str.length();i++) {
            int j = str.charAt(i) - '0';
            soureList.add(alphabet[j]);
        }

        List<String> res = new ArrayList<>();
        getCombition(soureList,0,"",res);

        return res;
    }

    private void getCombition(List<String> sourceList,int index,String str,List<String> res){
        if(index == sourceList.size()){
            res.add(str);
            return;
        }

        String strTemp = sourceList.get(index);
        index++;
        for(int i=0;i<strTemp.length();i++){
            StringBuilder sb = new StringBuilder(str);
            sb.append(strTemp.charAt(i));
            getCombition(sourceList,index,sb.toString(),res);
        }
    }


    public static void main(String[] args) {
        NumLetterCombition instance =new NumLetterCombition();

        List<String> res = instance.solution("2");

        System.out.println(res);
    }
}
