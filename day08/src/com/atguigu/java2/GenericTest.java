package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 *
 * 2。通配符的使用
 *
 *
 * @author yuqiCao
 * @create 2021-03-18 11:27 上午
 */
public class GenericTest {

    /*
    1.泛型在继承方面的体现

    类A是类的父类，G<A> 和G<B>二者不具有子父类关系,二者是并列关系
    补充：类A是类B的父类，A<G>是B<G>的父类

     */

    @Test
    public void test1(){

        Object obj = null;
        String str = null;

        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        //编译不通过
//        Date date = new Date();
//        str = date;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<>();
        //此时的list1和list2的类型不具有子父类的关系
        //编译不通过
//        list1 = list2;

        /*
        反证法：
        假设list1 = list2;


         */




    }

    /*
    2。通配符的使用
       通配符：?

        类A是类的父类，G<A> 和G<B>二者不具有子父类关系,二者是并列关系,二者共同的父类是：G<?>


     */
    @Test
    public void test2(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        //编译通过：
//        print(list1);
//        print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
        //添加：对于List<?>就不能向其内部添加数据。
        //除了null之外
//        list.add("DD");
//        list.add("?")
        list.add(null);

        //获取（读取）:允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);


    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
    /*
    3.有限制条件的通配符的使用.
     ? extends A :
             G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类

     ? super A :
             G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

     */
    @Test
    public void test3() {

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 =  new ArrayList<Person>();
        List<Object> list5 =  new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
//        Student s = list1.get(0);
        list2 = list4;
        //编译不通过
//        Person p1 = list2.get(0);
        Object obj = list2.get(0);

        //写入数据
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());


    }


}
