package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 找出二叉树的右视图
 * 思路：利用queue 层序遍历，打印每层的最右侧节点
 */
public class RightNode {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root){
            return list;
        }
        Queue queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = (TreeNode) queue.poll();
                if(i==size-1){
                    list.add(node.getVal());
                }
                if(node.getLeft()!=null){
                    queue.offer(node.getLeft());
                }

                if(node.getRight()!=null){
                    queue.offer(node.getRight());
                }
            }
        }

        return list;
    }
}
