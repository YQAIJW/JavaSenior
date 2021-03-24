package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**

 * 关于java.lang.Class类的理解
 *  *
 *  * 1。类的加载过程：
 *  * 程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾）.接着我们使用java.exe
 *  * 命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程就称为类的加载。
 *  * 加载到内存中的类，我们就称为运行时类，此时运行的类，就作为Class的一个实例。
 *  *
 *  * 2。换句话说，Class的实例就对应着一个运行时类。
 *
 *    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类
 * @author yuqiCao
 * @create 2021-03-21 11:34 下午
 */
public class ReflectionTest {

    //获取Class的实例的方式
    @Test
    public void test1() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true


        //方式四：使用类的加载器：ClassLoader(了解)

        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);


    }
    /*
    Properties:写配置文件
     */
    @Test
    public void test2() throws IOException {

        Properties pros = new Properties();
        //此时文件默认在当前的module下。
        //读取配置文件的方式一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式二：
        //配置文件默认识别为当前module的src下
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ", password = " + password);

    }

}
