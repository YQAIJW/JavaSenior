package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqiCao
 * @create 2021-03-17 6:17 下午
 */
public class SubOrder extends Order<Integer>{//不是泛型类
    public <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E > list = new ArrayList<>();
        for (E e :arr){
            list.add(e);
        }
        return list;
    }
}
