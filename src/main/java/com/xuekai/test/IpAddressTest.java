package com.xuekai.test;

import java.util.ArrayList;
import java.util.List;

/**
 * ip复原
 */
public class IpAddressTest {

    public static void main(String[] args) {
        String s ="2331019289";
        IpAddressTest instance = new IpAddressTest();
        List<String> result = new ArrayList<>();
        instance.solution(s,1,"",result);

        System.out.println(result);
    }

    public void solution(String str, int k, String address, List<String> res){
        if(k==5 && str.length()==0){
            //注意去除最后一个点符号
            res.add(address.substring(0,address.length()-1));
            return;
        }

        int remain = 5-k;
        //长度超过最大，或小于最小
        if(str.length()>(remain*3) || str.length()<remain){
            return;
        }

        for(int i=1;i<=3;i++){
            if(str.length()<i){
                return;
            }
            String part = str.substring(0,i);
            if(!isNum(part)){
                return;
            }

            solution(str.substring(i),k+1,address+part+".",res);
        }
    }

    private boolean isNum(String part){
        if(part == null || part.length()==0){
            return false;
        }

        if(part.length()>1 && part.startsWith("0")){
            return false;
        }

        int num = Integer.parseInt(part);

        if(num>=0 && num<=255){
            return true;
        }else {
            return false;
        }
    }
}
