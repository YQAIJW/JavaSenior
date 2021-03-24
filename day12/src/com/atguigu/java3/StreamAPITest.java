package com.atguigu.java3;

import org.junit.Test;

/**
 * 1.Stream关注的是对数据的运算，与cpu打交道
 *   集合关注的是数据的存储，与内存打交道
 *
 * 2.
 * 1⃣️Stream 自己不会存储元素。
 * 2⃣️不会改变原对象。相反，他们会返回一个持有结果的新Stream。
 * 3⃣️Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 *1⃣️ Stream的实例化
 *2⃣️一系列的中间操作（过滤，映射，...）
 *3⃣️终止操作
 *
 *
 * 4.说明
 *4。1 一个中间操作链，对数据源的数据进行处理
 *4。2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，就不会再被使用
 * @author yuqiCao
 * @create 2021-03-23 9:32 下午
 */
public class StreamAPITest {

    //1.创建Stream方式一：通过集合
    @Test
    public void test1(){

    }



}
