package com.allin.java2;

/**
 * 线程通信的例子：使用两个线程1-100。线程1，线程2交替打印
 * <p>
 * 涉及到的三个方法：
 * wait()：一旦执行此方法，当前线程就会进入阻塞状态，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒wait的下个进程。如果有多个进程，就唤醒优先级最高的那个进程
 * notifyAll()：一旦执行此方法，就会唤醒wait的所有进程
 * <p>
 * 说明：
 * 1.wait()，notify()，notifyAll()三个方法必须使用在同步代码块或同步方法中。
 * 2.wait()，notify()，notifyAll()三个方法必须是同步代码块或同步方法中的同步监视器。
 *      否则，会出现IllegalMonitorStateException异常
 * 面试题：sleep()和wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2.不同点：
 *  1）两个方法声明的位置不同：Thread类中的声明sleep()，Object类中声明wait()
 *  2）调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码快或同步方法中使用
 *  3）关于是否释放同步监视器：如果两个方法都是使用在同步代码块或同步方法中，sleep()不会释放锁，而wait()反之
 */

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {

        while (true) {

            synchronized (this) {

                notify();

                if (number <= 100) {
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
                } else {
                    break;
                }
            }
        }
    }
}