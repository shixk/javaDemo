package com.xuekai.algorithm;

import com.xuekai.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shixuekai
 * @CreateDate 2021/3/30
 * @Description
 **/
public class LeetcodeMindepth {

    private int solution(TreeNode root){

        if(root==null){
            return  0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result=0;
        while (!queue.isEmpty()){
            result++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.getRight()==null&&node.getLeft()==null){
                    return result;
                }


                if(node.getLeft()!=null){
                    queue.offer(node.getLeft());
                }

                if(node.getRight()!=null){
                    queue.offer(node.getRight());
                }

            }
        }

        return result;
    }
}
