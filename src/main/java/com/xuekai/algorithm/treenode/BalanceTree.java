package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
public class BalanceTree {


    public Boolean solution(TreeNode node){
        if(null == node){
            return true;
        }
        //左侧平衡，右侧平衡，左右高度差不超过1
        return (solution(node.getLeft()) && solution(node.getRight()) && Math.abs(getHigh(node.getLeft())-getHigh(node.getRight()))<2);
    }


    /**
     * 获取子树的高度
     * @param node
     * @return
     */
    private int getHigh(TreeNode node){
        if(node == null){
            return 0;
        }

        return 1+Math.max(getHigh(node.getLeft()),getHigh(node.getRight()));
    }
}
