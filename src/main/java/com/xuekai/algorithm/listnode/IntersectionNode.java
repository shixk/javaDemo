package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 */
public class IntersectionNode {


    public ListNode solution(ListNode headA, ListNode headB){
        if(headA==null || headB==null){
            return null;
        }

        int lengthA = 0;
        int lengthB = 0;
        ListNode res = null;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA!=null){
            lengthA++;
            curA = curA.getNext();
        }

        while (curB!=null){
            lengthB++;
            curB = curB.getNext();
        }

        ListNode pA=headA;
        ListNode pB=headB;
        //a比b长时
        if(lengthA>lengthB){
            int n = lengthA-lengthB;
            for(int i=1;i<=n;i++){
                pA=pA.getNext();
            }
        }else if(lengthB>lengthA){
            int n = lengthB-lengthA;
            for(int i=1;i<=n;i++){
                pB=pB.getNext();
            }
        }

        while (pA!=null && pB!=null){
            if(pA==pB){
                res=pA;
                break;
            }

            pA=pA.getNext();
            pB=pB.getNext();
        }

        return res;

    }
}
