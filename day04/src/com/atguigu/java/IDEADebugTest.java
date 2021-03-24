package com.atguigu.java;

import org.junit.Test;


/**
 * @author yuqiCao
 * @create 2021-03-11 1:07 下午
 */


public class IDEADebugTest{

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//null

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}
