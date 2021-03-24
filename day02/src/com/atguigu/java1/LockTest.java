package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 ---jdk 5.0新增
 *
 *
 * 1.面试题：synchronized 与lock的异同？
 *
 *  相同：二者都可以解决线程安全问题
 *  不同：synchronized机制在执行完相应的逻辑后，自动的释放同步监视器
 *       lock需要手动地启动同步（lock（）），同时结束也需要手动地实现（unlock（））
 *
 *2.优先使用顺序：
 *  lock —— 同步代码块（已经进了方法体，分配了相应资源） —— 同步方法
 *
 *  面试题：如何解决线程安全问题？有几种
 *
 *
 *
 *
 *
 *
 * @author yuqiCao
 * @create 2021-03-08 2:15 下午
 */

class Window implements Runnable{

    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);


    @Override
    public void run() {
        while (true){
            try{
                //2.调用锁定的方法lock()
                lock.lock();

                if (ticket > 0 ){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":售票，票号为" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3.调用解锁方法unlock
                lock.unlock();
            }


        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
