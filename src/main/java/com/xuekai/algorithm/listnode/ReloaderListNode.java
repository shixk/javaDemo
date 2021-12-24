package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * 重排链表
 */
public class ReloaderListNode {


    public void solution(ListNode head){
        if(head == null || head.getNext() == null){
            return;
        }
        //找到中间节点，分为前后两段
        ListNode mid = getMiddleNode(head);
        //后半段倒置
        ListNode lastList = reverse(mid.getNext());
        mid.setNext(null);
        ListNode preList = head;
        while (lastList != null){
            ListNode temp = lastList;
            lastList = lastList.getNext();
            temp.setNext(preList.getNext());
            preList.setNext(temp);
            preList = preList.getNext().getNext();
        }

    }


    private ListNode getMiddleNode(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.getNext() !=null && fast.getNext().getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.setNext(head);
        ListNode cur = head;
        while (cur.getNext() != null){
            ListNode newH = cur.getNext();
            cur.setNext(newH.getNext());
            newH.setNext(dummy.getNext());
            dummy.setNext(newH);
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

        ReloaderListNode instance = new ReloaderListNode();
        instance.solution(node1);

        System.out.println(node1);
    }
}
