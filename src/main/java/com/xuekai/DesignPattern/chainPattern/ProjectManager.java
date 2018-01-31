package com.xuekai.DesignPattern.chainPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/31
 * @Description
 **/
public class ProjectManager extends Handler{
    @Override
    public String handleRequest(User user, int fee) {

        String result="项目经理没有权限处理";
        if(fee<500){
            if(user.getName().equals("张三")){
                result="项目经理拒绝了"+user.getName()+"申请"+fee+"的请求";
            }
            else{
                result="项目经理同意了"+user.getName()+"申请"+fee+"的请求";
            }


        }else {
            //传递给下一个责任者处理请求
            if(getSuccessor()!=null){
                return getSuccessor().handleRequest(user,fee);
            }
        }

        return result;
    }
}
