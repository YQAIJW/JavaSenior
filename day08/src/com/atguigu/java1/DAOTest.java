package com.atguigu.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author yuqiCao
 * @create 2021-03-18 11:04 上午
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());

        List<Customer> list = dao1.getForList(10);

        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);

    }

}
