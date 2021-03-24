package com.atguigu.java1;

import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yuqiCao
 * @create 2021-03-15 10:46 上午
 */
public class TreeSetTest {
    @Test
    public void test1(){
        /*
        1.向TreeSet中添加的数据，要求是相同类的对象。
        2。两种排序方式：自然排序(实现Comparable接口) 和 定制排序（实现Comparator接口）

        3。自然排序中，比较的是两个对象是否相同的标准为：compareTo返回0.不再是equals().
        4。自然排序中，比较的是两个对象是否相同的标准为：compare返回0.不再是equals().



         */

        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象：
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tom",12));
      //举例一：
        set.add(23);
        set.add(56);
        set.add(-47);
        set.add(9);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
