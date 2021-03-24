package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author yuqiCao
 * @create 2021-03-22 12:35 上午
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    public void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }


}
