package com.xuekai.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/26
 * @Description LRU
 **/
public class LruCache {

    public class Node{
        int key,val;
        Node pre,next;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    public class DoubleList{
        //头结点和尾结点
        private Node head,tail;
        private int size;

        public void addFirst(Node n){
            if(head==null){
                head=tail=n;
            }else {
                Node oldHead = head;
                oldHead.pre = n;
                n.next = oldHead;
                head = n;
            }
            size++;
        }

        //注意node是否为头或者尾
        public void remove(Node node){
            if(node == head && node == tail){
                head=null;
                tail=null;
            }else if(node == head){
                node.next.pre = null;
                head = node.next;
            }else if(node == tail){
                node.pre.next = null;
                tail = node.pre;
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

        public int size() {
            return size;
        }

    }


    private Map<Integer,Node> map;
    private DoubleList cache;
    private int cap;

    public LruCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        cache.remove(node);
        cache.addFirst(node);

        return node.val;
    }


    public void put(int key,int val){
        Node node = new Node(key,val);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key,node);
        }else {
            if(cache.size()==cap){
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(node);
            map.put(key,node);
        }

    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);

        lruCache.put(2,1);
        lruCache.put(2,2);
        lruCache.get(2);
        lruCache.put(1,1);
        lruCache.put(4,1);
        lruCache.get(2);
    }

}
