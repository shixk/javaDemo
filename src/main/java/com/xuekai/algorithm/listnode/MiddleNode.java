package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

import java.util.List;

/**
 * 寻找单链表的中间节点
 */
public class MiddleNode {


    public ListNode solution(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
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


        System.out.println("快慢指针法是");

        // ListNode newList = reverse1(node1);

        MiddleNode instance = new MiddleNode();
        ListNode node = instance.solution(node1);

        System.out.println(node);


        ListNode newHead = instance.reverse(node1);

        System.out.println(newHead);

    }


    public ListNode reverse(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.setNext(head);
        ListNode cur = head;
        while (cur.getNext()!=null){
            ListNode newH = cur.getNext();
            cur.setNext(newH.getNext());
            newH.setNext(dummy.getNext());
            dummy.setNext(newH);
        }

        return dummy.getNext();
    }
}
