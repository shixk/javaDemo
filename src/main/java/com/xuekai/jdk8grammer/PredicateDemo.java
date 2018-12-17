package com.xuekai.jdk8grammer;

import com.xuekai.entity.People;

import java.util.function.Predicate;

/**
 * @Author shixuekai
 * @CreateDate 2018/12/17
 * @Description
 **/
public class PredicateDemo {

    public static void main(String[] args) {
        People  people=new People("xiaoming",23,"asd001");

        checkAge(p->p.getAge()>20,people,"年龄超过20岁，不满足业务需求");

        System.out.println("执行业务");

    }


    private static People checkAge(Predicate<People> predicate,People p,String msg){
        if(predicate.test(p)){
            throw new RuntimeException(msg);
        }

        return p;
    }
}
