package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/**
 * 求二叉树的直径
 * 思路 ：分别找到左子树最大深度，右子树的最大深度
 *       然后左右相加
 */
public class DiameterOfBinaryTree {

    private int ans=0;

    public int solution(TreeNode root){

        if(root == null){
            return 0;
        }

        //为叶子节点时
        if(root.getLeft() ==null && root.getRight()==null){
            return 0;
        }
        dfs(root);
        return ans;
    }

    //深度遍历，找出树的最大高度
    private int dfs(TreeNode root){
        if(root == null) {
            return 0;
        }
        int l=0,r=0;
        if(root.getLeft() != null){
            l+=dfs(root.getLeft());
        }

        if(root.getRight() != null){
            r+=dfs(root.getRight());
        }

        ans = Math.max(ans,r+l);
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setVal(2);
        TreeNode left = new TreeNode();
        left.setVal(1);
        left.setLeft(null);
        left.setRight(null);
        TreeNode right = new TreeNode();
        right.setVal(3);
        right.setRight(null);
        right.setLeft(null);

        root.setLeft(left);
        root.setRight(right);

        DiameterOfBinaryTree instance = new DiameterOfBinaryTree();

        System.out.println(instance.solution(root));

    }
}
