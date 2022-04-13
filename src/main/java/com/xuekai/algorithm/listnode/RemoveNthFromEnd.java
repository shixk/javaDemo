package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

//删除倒数第n个节点
public class RemoveNthFromEnd {

    //假如链表有6个节点，倒数第2个，就是正数第6-2+1=5个，so只要删除第5个节点即可
    //那么根据公式可以得出目标节点的pre=6-2;则把pre指向target.next即可
    public ListNode solution(ListNode head,int n){
        if(null == head){
            return head;
        }

        ListNode cur = head;
        int length = 0;
        while (cur!=null){
            length++;
            cur = cur.getNext();
        }
        //目标节点的前一个节点preIndex
        int target=length-n;
        int index = 0;
        if(target == index){
            return head.getNext();
        }

        ListNode temp = head;
        while (temp != null){
            index++;
            if(index == target){
                //执行删除目标节点
                temp.setNext(temp.getNext().getNext());
                break;
            }else {
                temp = temp.getNext();
            }
        }

        return head;
    }
}
