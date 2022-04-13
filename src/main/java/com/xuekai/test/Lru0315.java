package com.xuekai.test;

import java.util.HashMap;
import java.util.Map;

public class Lru0315 {

    public class Node{
        String key;
        String val;
        Node pre,next;

        public Node(String key,String val){
            this.key=key;
            this.val=val;
        }
    }

    public class DoubleList{
        int size;
        Node head;
        Node tail;

        public DoubleList(){
            this.size=0;
        }

        public void addFirst(Node node){
            if(head==null && tail==null){
                head=tail=node;
            }else{
                Node old = head;
                node.next = old;
                old.pre = node;
                head = node;
            }

            this.size++;
        }

        public void remove(Node node){
            if(node==head && node==tail){
                head=tail=null;
            }else if(node ==head && node!=tail){
                head = node.next;
                node.next.pre=null;
            }else if(node !=head && node==tail){
                tail = node.pre;
                node.pre.next=null;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            this.size--;
        }

        public Node removeLast(){
            Node last = tail;
            remove(last);

            return last;
        }
    }

    public class LruCache{
        Map<String,Node> map;
        DoubleList doubleList;
        int capacity;

        public LruCache(int capacity){
            this.capacity=capacity;
            this.map=new HashMap<>();
            this.doubleList=new DoubleList();
        }

        public void put(String key,String val){
            Node newNode = new Node(key,val);
            if(map.containsKey(key)){
                Node oldNode = map.get(key);
                doubleList.remove(oldNode);
                doubleList.addFirst(newNode);
            }else {
                if(doubleList.size==this.capacity){
                    Node last = doubleList.removeLast();
                    map.remove(last.key);

                }
                doubleList.addFirst(newNode);
            }

            map.put(key,newNode);
        }

        public String get(String key){
            if(map.containsKey(key)){
                Node node = map.get(key);
                doubleList.remove(node);
                doubleList.addFirst(node);
                return node.val;
            }else {
                return null;
            }
        }
    }


}
