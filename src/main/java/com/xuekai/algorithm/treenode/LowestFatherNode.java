package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/**
 * 二叉树的公共祖先
 */
public class LowestFatherNode {


    public TreeNode solution(TreeNode root,TreeNode p, TreeNode q){
        if(root==null||root==p||root==q){
            return root;
        }

        TreeNode left = solution(root.getLeft(),p,q);
        TreeNode right = solution(root.getRight(),p,q);
        if(left==null && right==null){
            return null;
        }else if(left==null && right!=null){
            return right;
        }else if(left!=null && right==null){
            return left;
        }

        return root;
    }
}
