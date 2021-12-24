package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 删除有序链表中的重复元素（不保留）
 */
public class DeleteSortDupNode2 {

    public ListNode solution(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        HashSet<Integer> set = new HashSet<>();
        ListNode temp = head;
        while (temp.getNext() != null){
            if(temp.getValue().equals(temp.getNext().getValue()) ){
                set.add(temp.getValue());
            }
            temp = temp.getNext();
        }

        ListNode cur = head.getNext();
        ListNode pre = head;
        while(cur != null){
            //删除该节点
            if(set.contains(cur.getValue())){
                pre.setNext(cur.getNext());
                cur = cur.getNext();
            }else {
                pre = cur;
                cur = cur.getNext();
            }
        }

        //最后还剩首节点未判断
        if(set.contains(head.getValue())){
            return head.getNext();
        }else {
            return head;
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
        node2.setValue(2);
        node2.setNext(node3);

        ListNode node1 = new ListNode();
        node1.setValue(4);
        node1.setNext(node2);

        DeleteSortDupNode2 instance = new  DeleteSortDupNode2();

        ListNode newh = instance.solution(node1);

        System.out.println(newh);
    }
}
