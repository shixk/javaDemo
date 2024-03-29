package com.xuekai.test;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author shixuekai
 * @CreateDate 2019/12/9
 * @Description
 **/
@Data
@NoArgsConstructor
public class User {

    private String name;

    private Integer type;

    private Integer minLeague;

    private Integer maxLeague;


    public User(String name, Integer type, Integer minLeague, Integer maxLeague){
        this.name=name;
        this.type=type;
        this.minLeague=minLeague;
        this.maxLeague=maxLeague;
    }

    public Boolean checkMsg(Checker checker){
        if(this.name.equals(checker.name)&&this.type.equals(checker.type)&&this.minLeague<=checker.minLeague&&this.maxLeague>checker.maxLeague){
            return true;
        }

        return false;
    }

    public static class Checker {
        private String name;

        private Integer type;

        private Integer minLeague;

        private Integer maxLeague;

        public Checker setName(String name){
            this.name=name;
            return this;
        }

        public Checker setType(Integer type){
            this.type=type;
            return this;
        }

        public Checker setMinLeague(Integer minLeague){
            this.minLeague=minLeague;
            return this;
        }

        public Checker setMaxLeague(Integer maxLeague){
            this.maxLeague=maxLeague;
            return this;
        }
    }


    public static void main(String[] args) {
        User user=new User("xuekai",1,10,200);
        Checker checker=new Checker().setName("xuekai").setType(1).setMinLeague(20).setMaxLeague(100);


        //将类对象参与的一些校验和check，封闭和维护在类内部本身
        //对外调用，仅使用check方法，提高可读性和可维护性
        System.out.println(user.checkMsg(checker));

    }


    public boolean isPalindrome(int x) {
        Boolean flag = true;
        String str = String.valueOf(x);
        int i=0,j=str.length()-1;
        while (i<j){
            if(str.charAt(i)!=str.charAt(j)){
                flag=false;
                break;
            }

            i++;
            j--;
        }

        return flag;
    }
}
