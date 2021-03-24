package com.atguigu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张。使用继承Thread类的方式
 *
 * 存在线程安全问题，待解决
 *
 * 使用同步代码块的解决继承Thread类的方式的线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 * @author yuqiCao
 * @create 2021-03-06 8:59 下午
 */

class Window extends Thread{

    private  static int ticket = 100;
    private  static Object obj = new Object();

    @Override
    public void run() {


        while (true){
            //正确的：
//            synchronized (obj) {
            synchronized (Window.class) {
                //错误的：此时this代表t1,t2,t3
                //synchronized(this){

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}




public class WindowTest {
    public static void main(String[] args) {

        Window t1 = new Window();
        Window t2 = new Window();
        Window t3 = new Window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
