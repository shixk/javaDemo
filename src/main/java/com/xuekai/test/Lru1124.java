package com.xuekai.test;

import java.util.HashMap;
import java.util.Map;

public class Lru1124 {


    public static class Node{
        String key,val;
        Node pre,next;

        public Node(String key,String val){
            this.key = key;
            this.val = val;
        }
    }

    public static class DoubleList{
        int size;
        Node tail,head;

        public DoubleList(){
            size = 0;
        }

        public void addFirst(Node node){
            if(head == null){
                head = tail = node;
            }else {
                Node old = head;
                old.pre = node;
                node.next = old;
                head = node;
            }
            size++;
        }

        public void remove(Node node){
            if(node == head && node == tail){
                head = tail = null;
            }else if(node == head && node != tail){
                head = node.next;
                node.next.pre = null;
            }else if(node == tail && node != head){
                tail = node.pre;
                node.pre.next = null;
            }else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            size--;
        }

        public Node removeLast(){
            Node node = tail;
            remove(node);
            //注意这里减少了2次数据！！！
            return node;
        }
    }

    public static class LruCache{
        int capacity;
        Map<String,Node> map;
        DoubleList doubleList;

        public LruCache(int cap){
            this.capacity = cap;
            this.map = new HashMap<>();
            this.doubleList = new DoubleList();
        }

        public void put(String key,String val){
            Node node = new Node(key,val);
            if(map.containsKey(key)){
                Node old = map.get(key);
                doubleList.remove(old);
                doubleList.addFirst(node);
            }else {
                if(doubleList.size == this.capacity){
                    Node last = doubleList.removeLast();
                    map.remove(last.key);
                }
                doubleList.addFirst(node);
            }

            map.put(key,node);
        }

        public String get(String key){
            if(!map.containsKey(key)){
                return null;
            }

            Node node = map.get(key);
            doubleList.remove(node);
            doubleList.addFirst(node);

            return node.val;
        }
    }

    public static void main(String[] args) {
        LruCache cache = new LruCache(3);

        cache.put("1","aa");
        cache.put("2","bb");
        cache.put("3","cc");
        cache.put("4","dd");

        System.out.println(cache.get("8"));

        System.out.println(cache.get("2"));

        cache.put("5","ee");

        cache.get("4");

        System.out.println("end");
    }
}
