package com.xuekai.DesignPattern.chainPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/31
 * @Description
 **/
public class GeneralManager extends Handler{
    @Override
    public String handleRequest(User user, int fee) {
        String re="总部经理未处理请求";
        if(fee>1000){
            if(user.getName().equals("张三")){
                re="总部经理拒绝了"+user.getName()+"申请"+fee+"的请求";
            }
            else{
                re="总部经理同意了"+user.getName()+"申请"+fee+"的请求";
            }
        }else {
            if(null!=getSuccessor()){
               return getSuccessor().handleRequest(user,fee);
            }
        }
        return re;
    }
}
