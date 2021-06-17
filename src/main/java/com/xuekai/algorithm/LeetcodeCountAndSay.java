package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2021/5/17
 * @Description
 * 1.     1
   2.     11
   3.     21
   4.     1211
   5.     111221
第一项是数字 1
描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-and-say
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LeetcodeCountAndSay {

    public static String solution(int n){
        String[] arr = new String[n];
        arr[0]="1";

        for(int i=1;i<=n-1;i++){
            arr[i]=sayCount(arr[i-1]);
        }

        return arr[n-1];
    }


    private static String sayCount(String str){
        String result="";
        int count=1;
        Character temp = str.charAt(0);
        char[] charArray = str.toCharArray();

        for(int i=1;i<charArray.length;i++){
            if (temp.equals(charArray[i])){
                count++;
            }else {
                result=result+count+temp;
                //初始化回去
                temp = charArray[i];
                count = 1;
            }
        }

        //最后一个遍历完成后，对未拼接的最后一个描述拼上去
        result=result+count+temp;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
