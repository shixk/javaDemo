package com.xuekai.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/5
 * @Description 杨辉三角
 **/
public class Yanghui {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> tempList = new ArrayList<>();
        for(int n=1;n<=numRows;n++){
            List<Integer> currentLine = generateNextLine(tempList,n);
            result.add(currentLine);
            tempList = currentLine;
        }
        return result;
    }


    private List<Integer> generateNextLine(List<Integer> preList,int n){

        List<Integer> currentLine = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i==0){
                currentLine.add(1);
            }else if(i == n-1){
                currentLine.add(1);
            }else {
                currentLine.add(preList.get(i)+preList.get(i-1));
            }
        }

        return currentLine;
    }

    public static void main(String[] args) {
        Yanghui clz = new Yanghui();

        List<List<Integer>> result = clz.generate(5);

        System.out.println(result);
    }
}
