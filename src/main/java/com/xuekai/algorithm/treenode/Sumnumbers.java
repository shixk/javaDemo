package com.xuekai.algorithm.treenode;

import com.xuekai.entity.TreeNode;

/***
 * 根到叶子节点路径之和
 */
public class Sumnumbers {

    private int sum = 0 ;

    private int solution(TreeNode root){
        if(root == null ){
            return 0;
        }

        dfs(root,"");

        return sum;
    }

    private void dfs(TreeNode root,String numStr){
        numStr = numStr + root.getVal();
        if(root.getLeft()!=null){
            dfs(root.getLeft(),numStr);
        }

        if(root.getRight()!=null){
            dfs(root.getRight(),numStr);
        }

        if(root.getLeft()==null&&root.getRight()==null){
            calculate(numStr);
        }
    }


    private void calculate(String str){
        int num = Integer.valueOf(str);

        sum = sum+num;
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

        Sumnumbers instance = new Sumnumbers();
        System.out.println(instance.solution(root));
    }
}
