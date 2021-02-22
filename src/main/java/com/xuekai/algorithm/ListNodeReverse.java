package com.xuekai.algorithm;

import com.xuekai.entity.ListNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/2/3
 * @Description
 **/
public class ListNodeReverse {

    //就地反转，双指针向前移动
    private static ListNode reverse1(ListNode head){
        ListNode dummy = new ListNode();
        //先指向首位
        dummy.setNext(head);
        ListNode pCur = head.getNext();
        ListNode prev = head;

        //走到最后时，弹出
        while (pCur != null){
            prev.setNext(pCur.getNext());

            pCur.setNext(dummy.getNext());

            dummy.setNext(pCur);

            pCur = prev.getNext();
        }

        //返回最新的指向
        return  dummy.getNext();
    }


    public static void main(String[] args) {

        ListNode node4 = new ListNode();
        node4.setValue(4);
        node4.setNext(null);

        ListNode node3 = new ListNode();
        node3.setValue(3);
        node3.setNext(node4);

        ListNode node2 = new ListNode();
        node2.setValue(2);
        node2.setNext(node3);

        ListNode node1 = new ListNode();
        node1.setValue(1);
        node1.setNext(node2);

        printList(node1);

        System.out.println("反转之后是");

        ListNode newList = reverse1(node1);

        printList(newList);

    }


    private static void printList(ListNode node){
        ListNode temp = node;
        while (temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }

    }
}
