package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/28
 * @Description 给定二叉树，找出最大深度
 **/
public class Maxdepth {


    public int solution(TreeNode root){

        int depth = 0;
        if(root == null){
            return depth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();

                if(node.getLeft()!=null){
                    queue.offer(node.getLeft());
                }

                if(node.getRight()!=null){
                    queue.offer(node.getRight());
                }
            }

            depth++;
        }

        return depth;
    }
}
