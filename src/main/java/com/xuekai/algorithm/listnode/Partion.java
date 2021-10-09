package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * 链表分割
 *
 * 思路：申请两个链表，一个只装比k小的minHead，一个只装比k大的maxHead
 */
public class Partion {

    public ListNode solution(ListNode head , int k){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode minHead = new ListNode();
        // 小链表的尾部节点
        ListNode min = minHead;
        ListNode maxHead = new ListNode();
        // 大数链表的尾部节点
        ListNode max = maxHead;

        ListNode cur = head;
        while (cur != null){
            if(cur.getValue()<k){
                min.setNext(cur);
                min = min.getNext();
            }else {
                max.setNext(cur);
                max = max.getNext();
            }
            cur = cur.getNext();
        }

        min.setNext(maxHead.getNext());

        return minHead.getNext();

    }
}
