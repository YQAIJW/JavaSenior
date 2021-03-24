package com.atguigu.exer1;

import java.util.List;

/**
 * 创建DAO类的对象，分别调用其save、get、update、list、delete方法来操作User对象，
 * 使用Junit单元测试类进行测试
 *
 *
 * @author yuqiCao
 * @create 2021-03-18 2:03 下午
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,24,"昆凌"));
        dao.save("1003",new User(1003,56,"蔡依林"));
        dao.save("1004",new User(1004,38,"侯佩岑"));

        dao.update("1003",new User(1003,39,"方文山"));

        dao.delete("1004");

        List<User> list = dao.list();
//        System.out.println(list);
        list.forEach(System.out::println);

    }

}
