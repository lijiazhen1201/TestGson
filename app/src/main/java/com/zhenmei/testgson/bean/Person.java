package com.zhenmei.testgson.bean;

/**
 * Created by zhenmei on 16/2/14.
 */
public class Person {

    private int id;
    private String name;
    private char sex;
    private boolean isMarried;

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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public Person(int id, String name, char sex, boolean isMarried) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.isMarried = isMarried;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", isMarried=" + isMarried +
                '}';
    }
}
