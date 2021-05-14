package com.xuekai.algorithm;

import com.google.common.collect.Lists;
import com.xuekai.entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/2
 * @Description 层序遍历
 **/
public class LevelOrderTraverse {

    private void levelOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            System.out.println(node.getVal());

            if(node.getLeft()!=null){
                queue.offer(node.getLeft());
            }

            if(node.getRight()!=null){
                queue.offer(node.getRight());
            }
        }
    }

    /**
     * 自底向上层序遍历
     * 思路先自顶向下层序遍历，然后压入栈中，然后再从栈弹出结果即可
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = Lists.newArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()){
            int length = queue.size();
            List<Integer> list = Lists.newArrayList();
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();

                list.add(node.getVal());

                if(node.getLeft()!=null){
                    queue.offer(node.getLeft());
                }

                if(node.getRight()!=null){
                    queue.offer(node.getRight());
                }
            }
            stack.push(list);
        }

        while (!stack.isEmpty()){
            List<Integer> list = stack.pop();

            resultList.add(list);
        }
        return resultList;
    }
}
