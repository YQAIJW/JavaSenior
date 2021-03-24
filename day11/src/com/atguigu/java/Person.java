package com.atguigu.java;

/**
 * 关于java.lang.Class类的理解
 *
 * 1。类的加载过程：
 * 程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾）.接着我们使用java.exe
 * 命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称为类的加载。
 * 加载到内存中的类，我们就称为运行时类，此时运行的类，就作为Class的一个实例。
 *
 * 2。换句话说，Class的实例就对应着一个运行时类。
 *
 *
 *
 * @author yuqiCao
 * @create 2021-03-21 1:17 下午
 */
public class Person {

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
    public void show(){
        System.out.println("我是一个人！");
    }

    private void showNation(String nation){
        System.out.println("我是一个" + nation +"人！");

    }
}
