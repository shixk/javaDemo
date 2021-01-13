package com.xuekai.algorithm;

/**
 * @Author shixuekai
 * @CreateDate 2020/12/18
 * @Description 两个大数字字符串相加
 **/
public class BigNumberAdd {

    public static void main(String[] args) {
        String str1="1234";

        String str2="45678";

        String re=addMethod(str1,str2);

        System.out.println(re);
    }


    private static String addMethod(String str1,String str2){


        StringBuffer sb = new StringBuffer();
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();

        int i = arr1.length-1;
        int j = arr2.length-1;
        //进位值
        int temp = 0;
        while (i>=0||j>=0){
            int a = 0;
            int b = 0;
            if(i>=0){
                a = arr1[i]-'0';
            }

            if(j>=0){
                b = arr2[j]-'0';
            }


            int c = (a+b+temp)%10;

            temp = (a+b+temp)/10 ;

            sb.append(c);

            i--;
            j--;
        }



        return sb.reverse().toString();
    }
}
