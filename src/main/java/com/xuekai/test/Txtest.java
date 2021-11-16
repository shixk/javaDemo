package com.xuekai.test;

import com.xuekai.entity.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author shixuekai
 * @CreateDate 2021/4/20
 * @Description
 **/
public class Txtest {


    public ListNode solution(ListNode head,int k){

        //先分成k个组
        List<ListNode> list = new ArrayList<>();
        for(int i=0;i<k;i++){
            ListNode node = new ListNode();
            list.add(node);
        }

        int count=0;
        ListNode cur = head;
        //遍历链表，按照k分组
        while(cur!=null){
            int index = count%k;
            ListNode node = list.get(index);
            node.setNext(cur);
            cur = cur.getNext();

            count++;
        }

        //再把每个分组串联成一个链表
        for(int i=0;i<list.size();i++){
            //最后一个组
            if(i == list.size()-1){
                break;
            }
            ListNode last = list.get(i);
            while (last.getNext()!=null){
                last = last.getNext();
            }
            last.setNext(list.get(i+1));
        }
        ListNode newHead = new ListNode();
        newHead.setNext(list.get(0));

        return newHead.getNext();
    }

}
