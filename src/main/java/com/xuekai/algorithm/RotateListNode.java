package com.xuekai.algorithm;

import com.xuekai.entity.ListNode;

import java.util.Stack;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/17
 * @Description 旋转链表
 *              给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置
 **/
public class RotateListNode {

    public ListNode rotateList(ListNode head,int k){
        int length = 1;
        ListNode lastNode = head;
        //即获得了长度，又得到了lastNode
        while(lastNode.getNext()!=null){
            length++;
            lastNode = lastNode.getNext();
        }

        //如果k恰好为实际链表长度，那么不就需要部分移动了
        int realK = k%length;
        if(realK == 0){
            return head;
        }

        lastNode.setNext(head);
        //找到新的"头"位置，原尾指向原头，新尾指向null，返回新头指针
        int newPoint = length-realK;
        ListNode cur = head;
        int count=0;//计数器
        ListNode result=null;
        while(cur!=null){
            count++;
            if(count==newPoint){
                result = cur.getNext();
                cur.setNext(null);
                break;
            }

            cur = cur.getNext();
        }

        return result;
    }
}
