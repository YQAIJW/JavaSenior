package com.atguigu.java;

import java.io.Serializable;

/**
 * Person类可序列化的要求
 * 1.需要实现接口：Serializable
 * 2.需要当前类提供一个当局常量：serializableUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也可以序列化
 * （默认情况下，基本数据可序列化）
 *补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 *
 * @author yuqiCao
 * @create 2021-03-20 1:33 下午
 */
public class Person implements Serializable {

    public static final  long serialVersionUID = 687987969758L;

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
