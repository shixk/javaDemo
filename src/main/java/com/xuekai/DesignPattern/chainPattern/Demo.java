package com.xuekai.DesignPattern.chainPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/1/31
 * @Description
 **/
public class Demo {

    public static void main(String[] args) {
        Handler h1=new ProjectManager();
        Handler h2=new DeptManager();
        Handler h3=new GeneralManager();
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        System.out.println("=============================");
        User zhangsan=new User();
        zhangsan.setAge(18);
        zhangsan.setName("张三");

        System.out.println("张三申请了400聚餐经费");
        System.out.println(h1.handleRequest(zhangsan,400));

        User lisi=new User();
        lisi.setAge(18);
        lisi.setName("李四");
        System.out.println("李四申请了800聚餐经费");
        System.out.println(h1.handleRequest(lisi,800));

    }
}
