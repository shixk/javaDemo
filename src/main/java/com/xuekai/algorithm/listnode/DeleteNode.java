package com.xuekai.algorithm.listnode;

import com.xuekai.entity.ListNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/27
 * @Description
 *
 * 提示：
链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。
 **/
public class DeleteNode {

    private ListNode head;

    public void delete(ListNode node){
        if(node == null) return;

        if(node.getNext().getNext()!=null){
            node.setValue(node.getNext().getValue());
            node.setNext(node.getNext().getNext());

        }else {
            node.setValue(node.getNext().getValue());
            node.setNext(null);
        }
    }
}
