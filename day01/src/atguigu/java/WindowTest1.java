package com.atguigu.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张。使用使用Runnable接口的方式
 *存在线程安全问题，待解决
 *
 * 1.问题：卖票过程中，出现了重票、错票 -->出现了线程的安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作这个车票。
 *
 *
 * @author yuqiCao
 * @create 2021-03-06 9:59 下午
 */
class  Window1 implements Runnable{

    private  int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为："+ ticket);
                ticket--;
            }else{
                break;
            }

        }
    }
}



public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

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
