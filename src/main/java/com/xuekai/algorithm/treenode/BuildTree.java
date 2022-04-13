package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/**
 * 给定两个数组，一个前序遍历preNums，一个按中序遍历inOrderNums，请构建出这课树
 */
public class BuildTree {

    int preIndex = 0;

    public TreeNode solution(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null) return null;

        return build(preorder,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int[] inorder,int inStart,int inEnd){
        if(inStart>inEnd) return null;
        TreeNode root = new TreeNode();
        root.setVal(preorder[preIndex]);
        //找到这个根节点在中序遍历数组中的位置
        int position = find(inorder,inStart,inEnd,preorder[preIndex]);
        if(position==-1) return  null;
        preIndex++;
        root.setLeft(build(preorder,inorder,inStart,position-1));
        root.setRight(build(preorder,inorder,position+1,inEnd));

        return root;
    }


    private int find(int[] inorder,int inStart,int inEnd,int val){
        for(int i=inStart;i<=inEnd;i++ ){
            if(inorder[i] == val){
                return i;
            }
        }

        return -1;
    }
}
