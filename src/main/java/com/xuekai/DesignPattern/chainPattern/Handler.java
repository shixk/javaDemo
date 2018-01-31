package com.xuekai.DesignPattern.chainPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/31
 * @Description
 **/
public abstract class Handler {

    protected Handler successor=null;

    public Handler getSuccessor(){
        return successor;
    }

    public void setSuccessor(Handler successor){
        this.successor=successor;
    }

    /**
     * 处理餐费申请
     * @param user
     * @param fee
     * @return 返回处理结果
     */
    public abstract String handleRequest(User user,int fee);
}
