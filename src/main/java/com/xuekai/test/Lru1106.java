package com.xuekai.test;


import java.util.HashMap;
import java.util.Map;

public class Lru1106 {

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
        Node head,tail;

        public DoubleList(){
            this.size = 0;
        }

        public void addFirst(Node node){
            if(head ==null && tail == null){
                head = tail = node;
            }else{
                Node oldHead = head;
                oldHead.pre = node;
                node.next = oldHead;
                node.pre = null;
                head = node;
            }

            size++;
        }

        public void remove(Node node){
            if(head == node && tail == node){
                head = tail = null;
            }else if(head == node && tail != node){
                node.next.pre = null;
                head = node.next;
            }else if(head != node && tail == node){
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
            remove(node);
            return node;
        }
    }


    public static class LruEntity {
        int capacity;
        Map<String,Node> map;
        DoubleList doubleList;

        public LruEntity(int capacity){
            this.capacity = capacity;
            map = new HashMap<>();
            doubleList = new DoubleList();
        }

        public void put(String key,String val){
            Node node = new Node(key,val);
            if(map.containsKey(key)){
                Node old = map.get(key);
                doubleList.remove(old);
            }else {
                if(doubleList.size>=this.capacity){
                    Node last = doubleList.removeLast();
                    map.remove(last.key);
                }
            }
            doubleList.addFirst(node);
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
        Lru1106 model = new Lru1106();
        Lru1106.LruEntity entity = new Lru1106.LruEntity(3);

        entity.put("1","a");
        entity.get("90");
        entity.put("2","b");
        entity.put("3","c");
        entity.put("4","d");

        String result = entity.get("2");

        System.out.println(result);
    }

}
