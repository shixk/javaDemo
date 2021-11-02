package com.xuekai.test;

import java.util.HashMap;
import java.util.Map;

public class LruTest {

    public static class Node{
        private String key,val;
        private Node pre,next;

        public Node(String key,String val){
            this.key = key;
            this.val = val;
        }

    }

    public static class DoubleList{
        int size;
        Node head,tail;

        public DoubleList(){
            this.size=0;
        }

        public void addFirst(Node node){
            if(head == null){
                head = tail = node;
            }else {
                Node oldHead = head;
                node.next = oldHead;
                oldHead.pre = node;
                head = node;
            }

            size++;
        }

        public void remove(Node node){
            if(node == head && node == tail){
                head=tail=null;
            }else if(node == head && node != tail){
                node.next.pre = null;
                head = node.next;
            }else if(node != head && node == tail){
                node.pre.next = null;
                tail = node.pre;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            size--;
        }

        public Node removeLast(){
            Node node = tail;
            node.pre.next = node.next;
            tail = node.pre;

            size--;
            return node;
        }
    }


    public static class LruCache{
        HashMap<String,Node> map;
        DoubleList doubleList;
        int capacity;

        public LruCache(int cap){
            this.capacity=cap;
            this.map = new HashMap<>();
            this.doubleList = new DoubleList();
        }

        public String getVal(String key){
            if(!map.containsKey(key)){
                return null;
            }
            Node node = map.get(key);
            doubleList.remove(node);
            doubleList.addFirst(node);
            return node.val;
        }

        public void put(String key,String val){
            Node newNode = new Node(key,val);
            if(doubleList.size>=capacity){
                Node last = doubleList.removeLast();
                map.remove(last.key);
            }
            doubleList.addFirst(newNode);
            map.put(key,newNode);
        }
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);
        cache.put("1","1");
        cache.put("2","bb");
        cache.put("3","c");

        System.out.println(cache.getVal("1"));

        cache.put("4","d");

        System.out.println(cache);
    }

}
