package com.xuekai.test;

import com.xuekai.entity.ListNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/12
 * @Description
 **/
public class ListNodeReverse {

    private ListNode reverse(ListNode head){
        ListNode dummy = new ListNode();
        dummy.setNext(head);

        ListNode cur = head.getNext();

        while (cur != null){
            head.setNext(cur.getNext());
            cur.setNext(dummy.getNext());
            dummy.setNext(cur);
            cur = head.getNext();
        }

        return dummy.getNext();
    }
}
