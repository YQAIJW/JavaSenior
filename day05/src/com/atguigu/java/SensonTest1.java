package com.atguigu.java;

/**
 *使用enum关键字定义枚举类
 * 说明：定义的枚举类默认继承于class java.lang.Enum类
 * @author yuqiCao
 * @create 2021-03-12 3:12 下午
 */
public class SensonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString()
        System.out.println(summer.toString());
        System.out.println("*********************");
        //values():
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);

        }
//        System.out.println(Season1.class.getSuperclass());
        System.out.println("*********************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);

        }


        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        //如果没有objName的枚举类对象，则抛异常：IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);

    }
}
enum Season1{

    //.提供当前枚举类的多个对象,多个对象之间用"，"隔开，末尾对象";"结束
    SPRING("春天","春暖花开"),
    SUMMER ("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER ("冬天","凛冬将至") ;

    //2.声明Season对象的属性:private final修饰
    private final String seasonName;
    private final String seasonDesc;

    //3.私有化类的构造器,并给对象属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4其他诉求1：获取枚举类对象的属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    //4其他诉求1：提供toString()


//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
