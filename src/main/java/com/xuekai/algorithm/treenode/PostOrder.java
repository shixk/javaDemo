package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/17
 * @Description 后序遍历
 **/
public class PostOrder {

    private void post(TreeNode root){
        if(root == null){
            return;
        }

        post(root.getLeft());
        post(root.getRight());
        System.out.println(root.getVal());
    }
}
