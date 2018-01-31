package com.xuekai.DesignPattern.chainPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/31
 * @Description
 **/
public class DeptManager extends Handler{

    @Override
    public String handleRequest(User user, int fee) {
        String re="部门经理未处理请求";
        if(fee>=500&&fee<=1000){
            if(user.getName().equals("张三")){
                re="部门经理拒绝了"+user.getName()+"申请"+fee+"的请求";
            }
            else{
                re="部门经理同意了"+user.getName()+"申请"+fee+"的请求";
            }
        }else{
            if(getSuccessor()!=null){
                return getSuccessor().handleRequest(user,fee);
            }
        }
        return re;
    }
}
