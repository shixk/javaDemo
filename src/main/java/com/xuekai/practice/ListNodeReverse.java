package com.xuekai.practice;

import com.xuekai.entity.ListNode;

public class ListNodeReverse {

    public ListNode solution(ListNode head){
        ListNode dummy = new ListNode();
        dummy.setNext(head);
        ListNode cur = head;
        while (cur.getNext()!=null){
            ListNode temp = cur.getNext();
            cur.setNext(temp.getNext());
            temp.setNext(dummy.getNext());
            dummy.setNext(temp);
        }

        return dummy.getNext();
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode();
        node5.setValue(5);
        node5.setNext(null);

        ListNode node4 = new ListNode();
        node4.setValue(4);
        node4.setNext(node5);

        ListNode node3 = new ListNode();
        node3.setValue(3);
        node3.setNext(node4);

        ListNode node2 = new ListNode();
        node2.setValue(2);
        node2.setNext(node3);

        ListNode node1 = new ListNode();
        node1.setValue(1);
        node1.setNext(node2);

        ListNodeReverse instance = new ListNodeReverse();
        ListNode head = instance.solution(node1);

        System.out.println(head);

    }
}
