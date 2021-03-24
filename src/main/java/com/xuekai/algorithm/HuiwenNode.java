package com.xuekai.algorithm;

import com.xuekai.entity.ListNode;

import java.util.Stack;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/11
 * @Description 判断是否一个回文链表
 **/
public class HuiwenNode {

    /**
     * 思路：引入一个栈，把链表从头到尾压入栈，然后再从头到尾对比栈顶的值
     * @param node
     * @return
     */
    private static boolean isHuiwen(ListNode node){
        Boolean flag = true;
        Stack<Integer> stack = new Stack();
        //将链表读取至栈中
        ListNode cur = node;
        while (cur!=null){
            stack.push(cur.getValue());
            cur=cur.getNext();
        }

        cur = node;

        while (cur!=null){
            Integer val = stack.pop();
            if(cur.getValue()!=val){
                flag = false;
                break;
            }

            cur = cur.getNext();
        }

        return flag;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode();
        node3.setValue(3);
        node3.setNext(null);

        ListNode node2 = new ListNode();
        node2.setValue(2);
        node2.setNext(node3);

        ListNode node1 = new ListNode();
        node1.setValue(1);
        node1.setNext(node2);

        System.out.println(isHuiwen(node1));
    }
}
