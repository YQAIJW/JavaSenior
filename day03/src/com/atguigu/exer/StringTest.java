package com.atguigu.exer;

/**
 * @author yuqiCao
 * @create 2021-03-09 4:16 下午
 */
public class StringTest {

//    String str = new String("good");
    String str = "good";
    char[] ch = {'t','e','s','t'};

    public void change(String str,char ch[]){
        this.str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }





}
