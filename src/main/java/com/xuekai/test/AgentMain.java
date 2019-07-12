package com.xuekai.test;

/**
 * @Author shixuekai
 * @CreateDate 2019/1/8
 * @Description
 **/
public class AgentMain {

    public static void main(String[] args) {
        //CtClass ctclass = ClassPool.getDefault().get("com.xuekai.test.AgentMain");
        System.out.println("===执行了主函数===");
        sayHello();
    }

    public static void sayHello(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello world");
    }
}
