package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/17
 * @Description 前序遍历
 **/
public class PreOrder {


    public void pre(TreeNode root){
        if(root == null){
            return;
        }

        System.out.println(root.getVal());
        pre(root.getLeft());
        pre(root.getRight());

    }
}
