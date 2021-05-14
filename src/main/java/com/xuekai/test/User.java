package com.xuekai.test;

import lombok.Data;

/**
 * @Author shixuekai
 * @CreateDate 2019/12/9
 * @Description
 **/
@Data
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

//题目描述给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
//使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//注意:不能使用代码库中的排序函数来解决这道题。样例输入[2,0,2,1,1,0]输出 [0,0,1,1,2,2]
