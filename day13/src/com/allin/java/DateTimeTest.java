package com.allin.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 */

public class DateTimeTest {

    /**
     * java.util.Date类
     *      |---java.sql.Date类
     *   1.两个构造器的使用
     *   2.两个方法的使用
     *      >toString():显示当前的年月日时分秒
     *      >getTime():获取当前Date对象对应的时间戳
     *   3.java.sql.Date对应着数据库中的日期类型的变量
     *      >如何实例化
     *      >java.util.Date对象 ---> java.sql.Date对象
     */

    @Test
    public void test3(){
        //创建java.sql.Date对象
        java.sql.Date date1 = new java.sql.Date(35235325345L);
        System.out.println(date1);

        //如何将java.util.Date对象 ---> java.sql.Date对象
        //情况一：
//        Date date2 = new java.sql.Date(2343243242323L);
//        java.sql.Date date3 = (java.sql.Date) date2;
        //情况二：
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);

    }

    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sun May 16 13:51:41 CST 2021
        System.out.println(date1.getTime());//1621144301475

        //构造器二:获取指定毫秒数的Date对象
        Date date2 = new Date(1621144301475L);
        System.out.println(date2.toString());
    }

    //1.System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之前一毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }
}
