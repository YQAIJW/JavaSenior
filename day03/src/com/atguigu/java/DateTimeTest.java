package com.atguigu.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author yuqiCao
 * @create 2021-03-10 5:30 下午
 */
public class DateTimeTest {

    /*
    java.util.Date类
              ---java.sql.Date类
    1.两个构造器的使用
    构造器一：Date()：创建了一个对应当前时间的Date对象
    构造器二：创建指定毫秒数的Date对象

    2.两个方法的使用
    >toString():显示当前的年、月、日、时、分、秒
    >getTime():获取当前时间的毫秒数。（时间戳）

    3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date --->java.sql.Date对象





     */
    @Test
    public void teat1(){
        //构造器一：Date()：创建了一个对应当前时间的Date对象
        Date d1 = new Date();
        System.out.println(d1.toString());//Wed Mar 10 19:12:49 CST 2021//显示当前的年、月、日、时、分、秒

        System.out.println(d1.getTime());//1615374920689//获取当前时间的毫秒数。（时间戳）


        //构造器二：创建指定毫秒数的Date对象
        Date d2 = new Date(1615374920689L);
        System.out.println(d2.toString());//Wed Mar 10 19:15:20 CST 2021//显示当前的年、月、日、时、分、秒

        //创建java.sql.Date对象
        java.sql.Date d3 = new java.sql.Date(1213244541515L);
        System.out.println(d3.toString());//2008-06-12

        //如何将java.util.Date --->java.sql.Date对象
        //情况一：多态
//        Date date4 = new java.sql.Date(1231441551555L);
//        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：毫秒数
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }




    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);



    }


}
