package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 范型的使用
 * 1.jdk5.0新增的特性
 * 2.在集合中使用范型：
 * 总结：≈
 * 1⃣️集合接口或集合类在jdk5.0时都修改为带泛型的结构
 * 2⃣️在实例化集合类时，可以指明具体的泛型类型
 * 3⃣️指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（如：方法、构造器、属性）使用到类的泛型，
 * 都指定为实例化的泛型类型。
 * add(E e) ---实例化后：add(Integer e)
 * 4⃣️泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 * 5⃣️如果实例化时，没有指明泛型的类型，默认类型为Object类型
 *
 * 3.如何自定义泛型结构：泛型类、泛型接口；泛型方法，见GenericTest1
 *
 * @author yuqiCao
 * @create 2021-03-17 4:27 下午
 */
public class GenericTest   {

    //在集合中使用泛型之前的情况：
    @Test
    public void tets1(){
        ArrayList list =new ArrayList();
        list.add(78);
        list.add(63);
        list.add(84);
        list.add(90);
        //问题一：类型不安全
//        list.add("Tom");

        for (Object score : list){

            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }


    }
    //在集合中使用泛型
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(78);
        list.add(48);
        list.add(68);
        list.add(88);

        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //方式一：
//        for (Integer score : list){
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
           int stuScore = iterator.next();
            System.out.println(stuScore);
        }


    }
    //在集合中使用范型的情况：以HashMap为例
    @Test
    public void test3(){

//        Map<String,Integer> map = new HashMap<String,Integer>();
        //jdk7新特性：类型推断
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",77);
        map.put("Gala",67);
        map.put("Peter",97);

//        map.put(123,"cd");

        //泛型嵌套
        //
        Set<Map.Entry<String,Integer>> entry = map.entrySet();

        Iterator<Map.Entry<String,Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---" + value);
        }


    }


}
