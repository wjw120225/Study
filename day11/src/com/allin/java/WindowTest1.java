package com.allin.java;
/**
 *例子：创建三个窗口买票，总票数为100张，使用实现Runnable接口的方式
 *
 *存在线程的安全问题，待解决
 */
class Window_1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票，票号为:" + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window_1 w = new Window_1();

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
