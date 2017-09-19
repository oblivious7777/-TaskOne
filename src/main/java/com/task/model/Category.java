package com.task.model;

public class Category {
    //这是大家熟悉的，建造一个Category对象所必须的
    //我百度了一下，似乎model对应数据的载体，category放在这个层比较好..
    private int id;
    private String name;
    private int age;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //重写的toString方法
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ",age="+age+"]";
    }



}
