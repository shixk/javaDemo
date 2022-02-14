package com.xuekai.test;

import java.util.HashMap;
import java.util.Map;

public class Lru1224 {

    public class Node {
        private String key,val;
        private Node next;
        private Node pre;

        public Node(String key,String val){
            this.key=key;
            this.val = val;
        }
    }

    public class DoubleList{
        int size;
        Node head,tail;

        public DoubleList(){
            this.size=0;
        }

        public void addFirst(Node node){
            if(this.head == null){
                this.head = this.tail = node;
            }else {
                Node oldh = this.head;
                node.next = oldh;
                oldh.pre = node;
                this.head = node;
            }

            this.size++;
        }

        public void remove(Node node){
            if(this.head == node && this.tail == node){
                this.head = this.tail = null;
            }else if(this.head == node && this.tail != node){
                this.head = node.next;
                node.next.pre = null;
                node.next = null;
            }else if(this.head != node && this.tail == node){
                this.tail = node.pre;
                node.pre.next = null;
                node.pre = null;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            this.size--;
        }

        public Node removeLast(){
            Node node = this.tail;
            remove(node);

            return node;
        }
    }

    public class CacheLru{
        private Map<String,Node> map;
        private DoubleList doubleList;
        private int capacity;

        public CacheLru(int cap){
            this.capacity = cap;
            map = new HashMap<>();
            doubleList = new DoubleList();
        }

        public void put(String key,String val){
            Node newNode = new Node(key,val);
            if(map.containsKey(key)){
                doubleList.remove(map.get(key));
                doubleList.addFirst(newNode);
            }else {
                if(doubleList.size == this.capacity){
                    Node last = doubleList.removeLast();
                    map.remove(last.key);
                }
                doubleList.addFirst(newNode);
            }

            map.put(key,newNode);
        }

        public String get(String key){
            if(!map.containsKey(key)){
                return "";
            }

            Node node = map.get(key);
            doubleList.remove(node);
            doubleList.addFirst(node);
            return node.val;
        }
    }
}
