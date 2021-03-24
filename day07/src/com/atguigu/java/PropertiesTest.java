package com.atguigu.java;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author yuqiCao
 * @create 2021-03-16 10:12 下午
 */
public class PropertiesTest {

    //Properties:常用来处理配置文件。key和value都是String类型
    public static void main(String[] args) throws Exception {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("name = " + name + ",password = " + password);
    }
}
