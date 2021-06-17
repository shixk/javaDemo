package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/6/4
 * @Description
 **/
public class SortListNode {

    public ListNode solution(ListNode head){
        if(head == null){
            return head;
        }

        ListNode cur = head;
        ListNode next = cur.getNext();
        while (next != null){

            //当前节点与后面每个节点进行对比，把最小的一个往前排
            while( next !=null ) {
                if (cur.getValue() > next.getValue()) {
                    swap(cur, next);
                } else {
                    next = next.getNext();
                }
            }

            cur = cur.getNext();
            next = cur.getNext();
        }

        return head;
    }

    private void swap(ListNode cur,ListNode next){
        int temp = cur.getValue();
        cur.setValue(next.getValue());
        next.setValue(temp);
    }

    private static void printList(ListNode node){
        ListNode temp = node;
        while (temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }

    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode();
        node4.setValue(3);
        node4.setNext(null);

        ListNode node3 = new ListNode();
        node3.setValue(2);
        node3.setNext(node4);

        ListNode node2 = new ListNode();
        node2.setValue(1);
        node2.setNext(node3);

        ListNode node1 = new ListNode();
        node1.setValue(4);
        node1.setNext(node2);

        printList(node1);

        SortListNode clz = new SortListNode();

        System.out.println("-------排序后--------");

        printList(clz.solution(node1));
    }
}
