package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/17
 * @Description 中序遍历
 **/
public class MiddleOrder {

    private void mid(TreeNode root){
        if(root == null){
            return;
        }
        mid(root.getLeft());
        System.out.println(root.getVal());
        mid(root.getRight());

    }
}
