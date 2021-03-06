package com.xuekai.algorithm;

import com.xuekai.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/2
 * @Description 层序遍历
 **/
public class LevelOrderTraverse {

    private void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            System.out.println(node.getVal());

            if(node.getLeft()!=null){
                queue.offer(node.getLeft());
            }

            if(node.getRight()!=null){
                queue.offer(node.getRight());
            }
        }
    }
}
