package com.xuekai.DesignPattern.builderPattern;

/**
 * @Author shixuekai
 * @CreateDate 2018/5/31
 * @Description
 **/
public class Person {

    private String name;

    private Integer age;

    private boolean sex;


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public boolean getSex() {
        return sex;
    }

    public static class Builder{
        private String name;

        private Integer age;

        private boolean sex;

        public Builder name(String n){
            this.name=n;
            return this;
        }

        public Builder age(int a){
            this.age=a;
            return this;
        }

        public Builder sex(boolean s){
            this.sex=s;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        this.name=builder.name;
        this.age=builder.age;
        this.sex=builder.sex;
    }



    public static void main(String[] args) {
        Person p=new Person.Builder().name("shixk").age(18).sex(true).build();

        System.out.println(p.getName()+"\n"+p.getAge()+"\n"+p.getSex());
    }
}
