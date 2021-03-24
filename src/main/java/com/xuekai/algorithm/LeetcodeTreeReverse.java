package com.xuekai.algorithm;

import com.xuekai.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/12
 * @Description 二叉树翻转
 *              思路都差不多，都是把每个节点的左右指针交换
 **/
public class LeetcodeTreeReverse {

    /**
     * 递归思路
     * @param root
     * @return
     */
    private TreeNode method1(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(left);

        //递归左侧节点
        method1(root.getLeft());
        method1(root.getRight());

        return root;
    }


    /**
     * 借助一个queue队列，按层级把每个节点的左右指针交互
     * @param root
     * @return
     */
    private TreeNode method2(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);

            if(node.getLeft()!=null){
                queue.offer(node.getLeft());
            }

            if(node.getRight()!=null){
                queue.offer(node.getRight());
            }

        }

        return root;

    }
}
