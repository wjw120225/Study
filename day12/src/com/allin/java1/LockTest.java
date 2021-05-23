package com.allin.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *解决线程安全问题的方式三：Lock锁 --- JDK5.0新增
 *
 * 面试题：
 * 1.synchronized与lock锁的异同？
 *  相同：二者都可以解决线程安全问题
 *  不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *       lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 * 2.如何解决线程的安全问题？有几种方式？
 *      lock锁   同步代码块   同步方法
 *
 * 优先使用顺序：
 * lock -> 同步代码快（已经进入了方法体，分配了相应资源） -> 同步方法（在方法体之外）
 */
//class Window implements Runnable{//方式一
class Window extends Thread{;//方式二
    private int ticket = 1000;
    //实例化ReentrantLock
//    private ReentrantLock lock = new ReentrantLock();//方式一
    private static ReentrantLock lock = new ReentrantLock();//方式二

    @Override
    public void run() {
        while (true){
           try{
               //调用lock()
               lock.lock();

               if(ticket > 0){
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                   System.out.println(Thread.currentThread().getName() + ":售票，票号为" + ticket);
                   ticket--;
               }else {
                   break;
               }
           }finally {
               //调用解锁的方法：unlock()
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

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
