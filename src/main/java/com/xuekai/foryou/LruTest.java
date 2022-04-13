package com.xuekai.foryou;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LruTest {

    public static class Node{
        String key,val;
        Node pre,next;

        public Node(String key,String val){
            this.key=key;
            this.val=val;
        }
    }

    public static class DoubleList{
        int size;
        Node head;
        Node tail;

        public DoubleList(){
            this.size=0;
        }

        public void addFirst(Node node){
            if(head==null && tail==null){
                head=tail=node;
            }else {
                Node oldHead = head;
                oldHead.pre = node;
                node.next = oldHead;
                node.pre = null;
                head = node;
            }
            size++;
        }

        public void remove(Node node){
            if(node==head && node==tail){
                head = tail = null;
            }else if(node==head && node!=tail){
                head = node.next;
                node.next.pre = null;
            }else if(node!=head && node==tail){
                tail = node.pre;
                node.pre.next=null;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            size--;
        }

        public Node removeLast(){
            Node last = tail;
            remove(last);

            return last;
        }
    }

    public static class LruCache{
        ConcurrentHashMap<String,Node> map;
        DoubleList doubleList;
        int capacity;

        public LruCache(int cap){
            this.capacity=cap;
            map=new ConcurrentHashMap<>();
            doubleList = new DoubleList();
        }

        public void put(String key,String val){
            Node node = new Node(key,val);
            //key存在时
            if(map.contains(key)){
                Node old = map.get(key);
                doubleList.remove(old);
                doubleList.addFirst(node);
            }else {
                if(doubleList.size==this.capacity){
                    Node last = doubleList.removeLast();
                    map.remove(last.key);
                }

                doubleList.addFirst(node);
            }

            map.put(key,node);
        }

        public String get(String key){
            //key不存在时
            if(!map.contains(key)){
                return null;
            }

            //key存在时
            Node node = map.get(key);
            doubleList.remove(node);
            doubleList.addFirst(node);
            return node.val;
        }
    }


    public static void main(String[] args) {
        //Node node1 = new Node("1","a");
        //Node node2 = new Node("2","b");

        LruCache cache = new LruCache(2);
        cache.put("1","a");
        cache.put("2","b");
        System.out.println(cache);

        cache.put("3","c");
        System.out.println("sss");



    }

}
