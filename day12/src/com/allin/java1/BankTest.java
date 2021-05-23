package com.allin.java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写成线程安全的
 */
public class BankTest {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

//    private static synchronized Bank getInstance() {
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }

    //    方式一：效率差
//    private static Bank getInstance(){
//        synchronized (Bank.class){
//            if (instance == null) {
//                instance = new Bank();
//            }return instance;
//        }
//    }
//    方式二:效率更高
    private static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }

            }
        }
        return instance;
    }

}
