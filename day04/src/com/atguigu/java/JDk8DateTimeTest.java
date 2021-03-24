package com.atguigu.java;

import org.junit.Test;

import java.time.*;

/**
 * @author yuqiCao
 * @create 2021-03-11 4:26 下午
 */
public class JDk8DateTimeTest {
    /*
    LocalDate、LocalTime、LocalDateTime的使用
    1.说明：LocalDateTime使用频率较高

     */

    @Test
    public void test1(){

        //now():当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx():
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不变性
        //withXxx()
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.withHour(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //不可变性
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime4);


        LocalDateTime localDateTime5 = localDateTime.minusDays(11);
        System.out.println(localDateTime);
        System.out.println(localDateTime5);

    }
    /*
    Instant的使用(瞬时点)
    类似于java.util.Date类


     */
    @Test
    public void test2(){
        //now():获取本初子午线的时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-03-11T08:57:18.357446Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //ofEpochMilli():获取自1970年1月1日0时0分（UTC）的毫秒数 ----Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 ---> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1615453384685L);
        System.out.println(instant1);



    }


}
