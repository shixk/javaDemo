package com.xuekai.jdk8grammer;

import java.util.Optional;

public class OptionalDemo {

    /**
     * Optional用来判断null值，并做一些列的语法糖。
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        User u=new User();

        System.out.println(getUserName(u));

        User user=new User();
        user.setuName("shixk");
        System.out.println(getUserName(user));
    }

    public static String getUserName(User user) throws Exception {
        return Optional.ofNullable(user).map(u->u.getuName()).orElse("Unkown");

        //return Optional.ofNullable(user).map(u->u.getuName()).orElseThrow(()-> new Exception("发生null异常"));

    }


    public static class User{

        private String uName;

        private Integer age;

        public String getuName(){
            return uName;
        }

        public void setuName(String uName){
            this.uName=uName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}




