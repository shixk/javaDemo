package com.xuekai.entity;

public class TrieNode {

    public Boolean isEnd;

    public TrieNode[] child;

    public TrieNode(){
        this.isEnd=false;
        //一个节点最多有26个子节点，因为只有26个字母
        this.child=new TrieNode[26];
    }
}
