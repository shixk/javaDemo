package com.xuekai.test;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author shixuekai
 * @CreateDate 2018/6/5
 * @Description
 **/
public class Calculate {

    //最终计算15+20-7这个公式
    public static void main(String[] args) {

        Stack<Long> stack1=new Stack<>();
        stack1.push(7l);
        stack1.push(20l);
        stack1.push(15l);
        //形成了一个【7，20，15】的栈

        Stack<String> stack2=new Stack<>();
        stack2.push("-");
        stack2.push("+");
        //形成了【-，+】的队列


        Long result=0l;
        while (true){
            if(stack2.empty()){
                result=stack1.peek();
                break;
            }
            Long a=stack1.pop();
            Long b=stack1.pop();
            String flag=stack2.pop();
            Long re=calcuMethod(a,b,flag);
            stack1.push(re);

        }

        System.out.println(result);

    }


    public static long calcuMethod(Long a,Long b,String flag){
        long result=0;
        switch (flag){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
                result=a/b;
                break;
        }

        return result;
    }


}
