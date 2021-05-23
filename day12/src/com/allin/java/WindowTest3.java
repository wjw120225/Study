package com.allin.java;
/**
 *使用同步方法解决Runnable接口的线程安全问题
 *
 * 关于同步方法的总结
 * 1.关于同步方法仍然涉及同步监视器，只是不需要我们显式声明
 * 2.非静态的同步方法，同步监视器是this
 *   静态的同步方法，同步监视器是：当前类的本身
 */
class Window3 implements Runnable{
    private int ticket = 1000;
    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private synchronized void show(){

            if(ticket > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
                ticket--;
            }
        }

}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

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

