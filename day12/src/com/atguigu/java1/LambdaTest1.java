package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * 1.举例：(o1,o2) -> Integer.compare(o1,02);
 * 2.格式：
 *       ->:lambda操作符或箭头操作符
 *       ->:左边：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *       ->：右边：lambda体（其实就是重写的抽象方法的方法体）
 *
 * 3.lambda表达式的使用：分为6种情况
 *
 *      总结：
 *       ->:左边：lambda形参列表的参数类型可以省略（类型推断）；如果lambda形参列表只有一个参数，其括号也可以省略
 *  *    ->:右边：lambda体应该使用一对{}包裹；如果lambda体只有一条执行语句（可能是return语句），{}也可以省略
 *
 *
 *
 * 4.lambda表达的本质：作为函数式接口的实例
 *
 *
 * 5.如果接口中只声明一个抽象方法，此接口就声明为函数式接口。我们可以在一个接口上使用函数式注解，
 * 这样做可以检查它是否是一个函数式接口。
 *
 * 6.之前使用的匿名实现类表示的现在都可以用lambda表达式来写
 *
 * @author yuqiCao
 * @create 2021-03-22 7:49 下午
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){


        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        System.out.println("*************************");
        Runnable r2 = () -> {
            System.out.println("我爱北京故宫");
        };



        r2.run();
    }

    //语法格式二：lambda需要一个参数，但是没有返回值。
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言与誓言");

        System.out.println("*****************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };

        con1.accept("区别");
    }

    //语法格式三：数据类型可以省略。因为可由编译器推断得出，称为"类型推断"
    @Test
    public void test3(){


        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };

        con1.accept("区别");

        System.out.println("*****************");

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };

        con2.accept("区别");

    }

    //语法格式四：lambda若只需要一个参数时。参数的小括号可以省略

    @Test
    public void test4(){

        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };

        con2.accept("区别");

        System.out.println("*****************");

        Consumer<String> con3 = s -> {
            System.out.println(s);
        };

        con3.accept("区别");
    }

    //语法格式五：lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(21, 34));

        System.out.println("*****************");

        Comparator<Integer> com2 = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(90, 87));
    }

    //语法格式六：当lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test7(){

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

        System.out.println(com2.compare(9, 87));


    }

}
