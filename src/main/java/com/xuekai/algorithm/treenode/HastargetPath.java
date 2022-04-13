package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

public class HastargetPath {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        treeNode.setVal(1);
        treeNode.setRight(right);
        treeNode.setLeft(left);
        left.setVal(3);
        right.setVal(5);

        HastargetPath instance = new HastargetPath();

        System.out.println(instance.hasPathSum(treeNode,7));

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }

        return dfsSearch(root,0,targetSum);
    }

    /**
     *
     * @param root
     * @param sum 从上面链路已经累加的和
     * @param targetSum
     * @return
     */
    public boolean dfsSearch(TreeNode root,int sum,int targetSum){
        if(root==null) {
            return false;
        }

        sum = sum + root.getVal();
        if(root.getLeft()==null && root.getRight()==null){
            return sum == targetSum;
        }
        boolean result = dfsSearch(root.getLeft(),sum,targetSum)||dfsSearch(root.getRight(),sum,targetSum);

        return result;
    }
}
