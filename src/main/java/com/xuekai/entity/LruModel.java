package com.xuekai.entity;

import java.util.HashMap;
import java.util.Map;

public class LruModel {

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
        Node head,tail;

        public DoubleList(){
            size = 0;
        }

        public void addFirst(Node node){
            if(head==null){
                head=tail=node;
                size++;
                return;
            }

            Node oldHead = head;
            node.next = oldHead;
            oldHead.pre=node;
            head = node;
            size++;
        }

        public void remove(Node node){
            if(head==node && tail==node){
                head = tail = null;
            }else if(head==node && tail != node){
                head = node.next;
                node.next.pre = node.pre;
            }else if(head != node && tail==node){
                tail = node.pre;
                node.pre.next = node.next;
            }else {
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }

            size--;
        }


        public Node removeLast(){
            Node node = tail;
            tail = node.pre;
            node.pre.next = node.next;
            size--;

            return node;
        }
    }

    public static class LruCa{
        Map<String,Node> map ;
        DoubleList doubleList;
        int capacity;

        public LruCa(int capacity){
            map = new HashMap<>();
            doubleList = new DoubleList();
            this.capacity =capacity;
        }

        public void put(String key,String val){
            if(map.containsKey(key)){
                get(key);
                return;
            }

            Node node = new Node(key,val);
            if(doubleList.size>=this.capacity){
                Node last = doubleList.removeLast();
                map.remove(last.key);
                doubleList.addFirst(node);
            }else {
                doubleList.addFirst(node);
            }
            map.put(key,node);

        }


        public String get(String key){
            if(!map.containsKey(key)){
                return null;
            }
            Node node = map.get(key);
            Node newNode = new Node(key,node.val);
            doubleList.remove(node);
            doubleList.addFirst(newNode);

            map.put(key,newNode);
            return newNode.val;
        }
    }

    public static void main(String[] args) {
        LruCa cache = new LruCa(4);
        cache.put("1","1");
        cache.put("2","2");
        cache.put("3","333");
        cache.get("1");

        cache.put("4","4321");
        cache.put("5","555");

        System.out.println(cache);
    }
}
