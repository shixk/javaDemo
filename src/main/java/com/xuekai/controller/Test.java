package com.xuekai.controller;

public class Test {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode deleteNode(TreeNode root,int key){
        if(root == null){
            return null;
        }

        //找到节点
        FatherAndSon target = search(null,root,key);
        //构建新节点
        TreeNode newNode = build(target.node.left,target.node.right);

        //指向父节点
        if(target.father == null){
            return new TreeNode();
        }

        if(target.father.left.val == key){
            target.father.left = newNode;
        }else {
            target.father.right = newNode;
        }
        return root;
    }

    public FatherAndSon search(TreeNode father,TreeNode root,int key){
        if(root.val == key){
            FatherAndSon fatherAndSon = new FatherAndSon(father,root);
            return fatherAndSon;
        }
        //左侧寻找
        if(root.val>key){
            return search(root,root.left,key);
        }else {
            //右侧找
            return search(root,root.right,key);
        }
    }

    public TreeNode build(TreeNode left,TreeNode right){
        //右孩子为空，则直接返回左孩子
        if(right == null){
            return left;
        }

        TreeNode dest = deep(right);
        dest.left = left;
        return right;
    }

    private TreeNode deep(TreeNode root){

        if(root.left == null){
            return root;
        }

       return deep(root.left);
    }


    public class FatherAndSon{
        TreeNode father;

        TreeNode node;

        public FatherAndSon(TreeNode father,TreeNode son){
            this.father = father;
            this.node = son;
        }
    }

}
