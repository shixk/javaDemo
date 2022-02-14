package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * 两数之和
 */
public class TwoSum {

    public ListNode solution(ListNode l1,ListNode l2){
        ListNode h1 = l1;
        ListNode h2 = l2;

        ListNode re = new ListNode();
        re.setNext(h1);
        if(h1 == null){
            return h2;
        }

        if(h2==null){
            return h1;
        }

        int an = 0;
        ListNode pre1 =h1;
        while (h1 !=null){
            if(h2 == null)break;
            int a = h1.getValue();
            int b = h2.getValue();

            int s = a+b+an;
            an = s/10;
            int val = s % 10;

            h1.setValue(val);

            pre1 = h1;
            h2 = h2.getNext();
            h1 = h1.getNext();
        }

        //h1还有剩余节点
        if(h1 !=null && h2 == null){
            while (h1 != null) {
                int sum = h1.getValue() + an;
                an = sum / 10;
                h1.setValue(sum % 10);
                pre1 = h1;
                h1 = h1.getNext();
            }

        }else if(h1 == null && h2 != null){
            int sum = h2.getValue()+an;
            an = sum/10;
            h2.setValue(sum%10);
            pre1.setNext(h2);
            pre1 = h2;
            h2 = h2.getNext();
            while (h2 !=null){
                sum = h2.getValue()+an;
                an = sum/10;
                h2.setValue(sum%10);
                pre1 = h2;
                h2 = h2.getNext();
            }
        }

        if(an !=0){
            ListNode nodeLast = new ListNode();
            nodeLast.setValue(an);
            nodeLast.setNext(null);

            pre1.setNext(nodeLast);
        }

        return re.getNext();
    }


    private ListNode reverse(ListNode head){
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


    public static void main(String[] args) {
        ListNode node3 = new ListNode();
        node3.setValue(9);
        node3.setNext(null);

        ListNode node2 = new ListNode();
        node2.setValue(4);
        node2.setNext(node3);

        ListNode node1 = new ListNode();
        node1.setValue(2);
        node1.setNext(node2);


        ListNode node7 = new ListNode();
        node7.setValue(9);
        node7.setNext(null);

        ListNode node6 = new ListNode();
        node6.setValue(4);
        node6.setNext(node7);

        ListNode node5 = new ListNode();
        node5.setValue(6);
        node5.setNext(node6);

        ListNode node4 = new ListNode();
        node4.setValue(5);
        node4.setNext(node5);

        TwoSum instance = new TwoSum();

        ListNode result = instance.solution(node1,node4);

        System.out.println(result);


    }
}
