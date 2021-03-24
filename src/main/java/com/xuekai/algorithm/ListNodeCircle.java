package com.xuekai.algorithm;

import com.xuekai.entity.ListNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/15
 * @Description 单向链表判断是否存在环
 **/
public class ListNodeCircle {

    private boolean isExsit(ListNode node){
        boolean flag = false;

        ListNode slow = node;
        ListNode fast = node;

        while(slow!=null&&fast.getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                flag = true;
                break;
            }
        }

        return flag;
    }
}
