package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * 删除排序链表的重复元素 （保留元素）
 * 例如：1->1->2->2->3
 * 结果: 1->2->3
 */
public class DeleteSortDupNode {

    public ListNode solution(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode cur = head.getNext();
        ListNode pre = head;
        while (cur != null){
            if(pre.getValue() == cur.getValue()){
                pre.setNext(cur.getNext());
                cur = cur.getNext();
            }else {
                pre = cur;
                cur = cur.getNext();
            }
        }

        return head;
    }
}
