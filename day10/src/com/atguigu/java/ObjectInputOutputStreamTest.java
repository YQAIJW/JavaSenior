package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用：
 * 1。ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型或对象的处理流。
 * 他的强大之处就是可以把Java中的对象
 *
 * 3.java对象可序列化需要满足相应的要求。见Person类
 *
 * 4。序列化机制
 *
 * @author yuqiCao
 * @create 2021-03-20 1:18 下午
 */
public class ObjectInputOutputStreamTest {

    /*
    序列化的过程：将内存中的Java对象保存到磁盘或提供网络传输出去
    使用ObjectOutputStream实现

     */
    @Test
    public void test1(){

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("我爱北京天安门"));

            oos.flush();//刷新操作

            oos.writeObject(new Person("徐嘉蔚",23));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }  /*
    反序列化：将磁盘文件中的对象还原为一个内存中的一个java对象
    使用ObjectInputStream


     */
    @Test
    public void testObjectInputStream(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

           Person p = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
