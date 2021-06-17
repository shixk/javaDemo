package com.xuekai.algorithm;

import com.xuekai.entity.TreeNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/27
 * @Description 判断是否是一个对称二叉树
 **/
public class SymmetryTreeNode {


    public boolean isSymmetry(TreeNode root){
        //只有一个根节点
        if(root==null) return true;
        else {
            return is(root.getLeft(),root.getRight());
        }
    }


    private boolean is(TreeNode root1,TreeNode root2){
        if(root1==null && root1==null) {
            return true;
        }else if(root1 ==null || root2== null){
            return false;
        }else {
            if(root1.getVal()==root2.getVal()){
                return is(root1.getLeft(),root2.getRight())&&is(root1.getRight(),root2.getLeft());
            }
        }

        return false;
    }
}
