package com.xuekai.test;

import com.xuekai.entity.TreeNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/8/15
 * @Description
 **/
public class TreeNodeReverse {

    public void reverse (TreeNode root){
        if(root == null){
            return;
        }

        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        reverse(root.getLeft());
        reverse(root.getRight());
    }
}
