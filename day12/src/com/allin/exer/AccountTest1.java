package com.allin.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 *银行有一个账户：
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 *      分析：
 *      1.是否多线程问题？是两个储户线程
 *      2.是否有共享数据？有，账户
 *      3.是否有线程安全问题？有
 *      4.需要考虑如何解决线程安全问题？同步机制：三种方式：lock锁
 */

public class AccountTest1 {
    public static void main(String[] args) {

        Account1 acct1 = new Account1(0);
        Customer1 c1 = new Customer1(acct1);
        Customer1 c2 = new Customer1(acct1);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}

class Account1{

    private double balance;
    private static ReentrantLock lock = new ReentrantLock();

    public Account1(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //存钱
    public void deposit(double amt){
        try{
            lock.lock();
            if(amt > 0){
                balance += amt;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存钱成功，余额为" + balance);
            }
        }finally {
            lock.unlock();
        }

    }
}

class Customer1 extends Thread{

    private Account1 acct1;


    public Customer1(Account1 acct1) {
        this.acct1 = acct1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct1.deposit(1000);
        }
    }
}