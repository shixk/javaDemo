package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TrieNode;

/**
 * 前缀树
 */
public class Trie {

    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word == null || word.length()==0){
            return;
        }
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            //不存在则新建一个包含该字母的节点对像
            if(cur.child[idx]==null){
                cur.child[idx] = new TrieNode();
            }
            //存在则继续判断下一个节点是否需要填充
            cur = cur.child[idx];
        }

        cur.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            //前缀树中不包含所查找的字母，返回
            if(cur.child[idx]==null){
                return false;
            }
            //包含，则继续向下一个字母去寻找
            cur = cur.child[idx];
        }

        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i)-'a';
            //前缀树中不包含所查找的字母，返回
            if(cur.child[idx]==null){
                return false;
            }
            //包含，则继续向下一个字母去寻找
            cur = cur.child[idx];
        }
        //能遍历完，则证明前缀树包含这个前缀词组
        return true;
    }
}
