package com.xuekai.test;

import com.xuekai.constant.CommonConst;

import java.util.ArrayList;
import java.util.List;

/**
 * ip地址复原
 */
public class RecoveryIp {


    public List<String> solution(String s){
        List<String> list = new ArrayList<>();
        matchStr("",0,list,s);
        return list;
    }

    /**
     *
     * @param str 新匹配的字符串
     * @param notCount 点的数量
     * @param list
     * @param lastStr
     */
    private void matchStr(String str,int notCount,List<String> list,String lastStr){
        if(notCount>=5){
            return;
        }

        if(notCount==4 && lastStr.equals("")){
            list.add(str);
            return;
        }

        //"23.35.10.123"
        int maxRemainLength = (4-notCount)*3;
        if(lastStr.length()>maxRemainLength){
            return;
        }

        for(int i=1;i<=3;i++){
            if(lastStr.length()<i){
                continue;
            }
            String sub = lastStr.substring(0,i);
            if(!isValidNum(sub)){
                continue;
            }


            matchStr(str.equals("")?sub:str+"."+sub,notCount+1,list,lastStr.substring(i));
        }

    }

    private Boolean isValidNum(String str){
        if(str.length()>3){
            return false;
        }

        //0 开头的字符串
        if(str.length()>1 && str.startsWith("0")){
            return false;
        }

        Integer a = Integer.valueOf(str);
        if(a<0 || a>255){
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        RecoveryIp instance = new RecoveryIp();
        String s = "25525511135";

        List<String> list = instance.solution(s);

        System.out.println(list);

    }
}
