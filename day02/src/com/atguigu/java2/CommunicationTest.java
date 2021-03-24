package com.atguigu.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100。线程1，线程2 交替打印
 *
 * 涉及到的三个方法：
 * wait():一旦执行此方法当前线程就进入阻塞状态，并释放同步监视器。
 * notify():一旦执行此方法，就会唤醒被wait()的一个线程。如果有多个线程被wait，就会唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait()的线程。
 *
 * 说明：
 * 1.wait(),notify(),notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 * 否则会报IllegalMonitorStateException异常。
 * 3.wait(),notify(),notifyAll()三个方法是定义在java.lang.Object类中。
 *
 * 面试题：sleep()与wait()的异同？
 *
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态。
 * 2。不同点：1）两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *          2)调用的范围/调用的要求不同：sleep()可以在是任何需要的场景下调用。wait()必须使用在同步代码块/同步方法中。
 *          3)关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()方法不会释放锁，wait()会释放锁
 *
 *
 *
 *
 * @author yuqiCao
 * @create 2021-03-08 3:54 下午
 */
class Number implements Runnable{
    private int number = 1;


    @Override
    public void run() {

        while (true){

            synchronized (this) {

                notify();

                if (number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }


        }


    }
}



public class CommunicationTest {
    public static void main(String[] args) {
        Number num = new Number();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }



}
