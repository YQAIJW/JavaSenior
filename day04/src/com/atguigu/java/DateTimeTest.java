package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 *
 * @author yuqiCao
 * @create 2021-03-11 1:37 下午
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1格式化：日期--->字符串
    1.2解析：格式化的逆过程，字符串 --->日期

    2。SimpleDateFormat的实例化

     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化: 字符串--->日期
        Date date = new Date();
        System.out.println(date);//Thu Mar 11 14:31:19 CST 2021

        String format = sdf.format(date);
        System.out.println(format);//2021/3/11 下午2:31

        //解析：格式化的逆过程，字符串 --->日期
        String str = "2021/4/11 下午2:26";
        Date date1 = sdf.parse(str);
        System.out.println(date1);//Sun Apr 11 14:26:00 CST 2021

        //************按照指定方式格式化和解析：调用带参的构造器************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化：
        String format1 = sdf1.format(date);
        System.out.println(format1);//2021-03-11 02:31:19
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式（通过构造器参数体现）
        //否则，抛异常
        Date date2 = sdf1.parse("2021-02-11 02:31:19");
        System.out.println(date2);//Thu Feb 11 02:31:19 CST 2021



    }
    /*
      练习一：字符串"2020-09-08"转换为java.sql.Date

      练习二："三天打鱼两天晒网" 1990-01-01 xxxx-xx-xx是：打渔？晒网？

      举例：2020-09-08？总天数

      总天数 % 5 ==1，2，3：打渔
      总天数 % 5 ==4，0：晒网

      总天数的计算？
      方式一：(date1.getTime() - date2.getTime()) /(1000 * 60 * 60 * 24) + 1
      方式二：1990-01-01 ---> 2019-12-31 + 2020-01-01 --->2020-09-08


       */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf2.parse(birth);
       // System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }



    /*
    Calendar日历类(抽象类)的使用

     */
    @Test
    public void testCalendar(){
        //实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 --->Date
        Date date = calendar.getTime();
        System.out.println(date);


        //setTime() Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);


    }
}
