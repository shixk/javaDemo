package com.xuekai.algorithm;

import apple.laf.JRSUIUtils;
import com.xuekai.entity.TreeNode;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/27
 * @Description
 **/
public class SameTree {


    public boolean  isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }else {
            if(root1.getVal() == root2.getVal()){
                return isSameTree(root1.getLeft(),root2.getLeft())&&isSameTree(root1.getRight(),root2.getRight());
            }
        }


        return false;
    }
}
