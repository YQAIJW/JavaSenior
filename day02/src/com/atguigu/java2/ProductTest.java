package com.atguigu.java2;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者（Producer）将产品交给店员（Clerk），而消费者（Consumer）从店员处取走产品，
 * 店员一次只能持有固定的数量的产品（比如20），如果生产者试图生产更多的产品，店员会叫生产
 * 者停一下，如果店内有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消
 * 费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1。是否是多线程的问题？是，生产者线程，消费者线程
 * 2。是否有线程安全问题（是否有共享数据的问题）？是，店员（或产品）
 * 3。处理线程安全的问题？同步机制，有三种方法
 * 4。是否涉及到线程的通信？是
 *
 *
 *
 *
 * @author yuqiCao
 * @create 2021-03-08 4:54 下午
 */
class Clerk{

    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        productCount ++;
        if(productCount <= 20){
            System.out.println(Thread.currentThread().getName() + ":开始生产第" +productCount +"个");

            notify();
        }
        else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount+"个");
            productCount--;

            notify();

        }else {
            //等待

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




class Producer extends Thread{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        System.out.println( getName() + ":开始生产产品");

        while (true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }
    }
}
class Consumer extends Thread{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println( getName() + ":开始消费产品");

        while (true){

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);

        p1.setName("生产者1");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");


        p1.start();
        c1.start();
    }

}
