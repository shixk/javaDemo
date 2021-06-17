package com.xuekai.algorithm;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/26
 * @Description 合并区间
 *              输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
                输出：[[1,6],[8,10],[15,18]]
                解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]
 **/
public class MergeIntervals {

    public static int[][] solution(int[][] arr){

        //按照左端点升序排序
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);

        int length = arr.length;
        int[] temp = arr[0];
        List<int[]> list = Lists.newArrayList();
        for(int i=1;i<length;i++){
            //当前右端点比后者左端点小，那么无重叠
            if(temp[1]<arr[i][0]){
                int[] interval = new int[temp.length];
                interval[0] = temp[0];
                interval[1] = temp[1];
                //确定了一个独立区间
                list.add(interval);

                temp[0] = arr[i][0];
                temp[1] = arr[i][1];

                continue;
            }

            //存在交集,则合并成为一个新的区间
            temp[1] = Math.max(temp[1],arr[i][1]);

        }
        //最后一次没有在循环中，需要额外添加
        list.add(temp);

        return list.toArray(new int[list.size()][]);

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        int[][] result = solution(arr);

        System.out.println(Arrays.asList(result));
    }

}
