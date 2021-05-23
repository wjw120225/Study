package com.allin.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8 中日期时间API的测试
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate() {
        //偏移量
        Date date = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date);//Tue Sep 08 00:00:00 CST 2020
    }

    /*
    LocalDate、LocalTime、LocalDateTime 的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime，使用频率要高
        2.类似于Calendar
     */
    @Test
    public void test1() {
        //now():获取当前的日期、时间、时间 + 日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 43);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(localTime.getMinute());

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(25);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(12);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }

    /*
    Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void test2() {
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2021-05-17T10:25:56.587Z

        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取1970年1月1日0时0分0秒（UTC）开始的毫秒数 ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);//1621305009977L

        //ofEpochMilli()：通过给定的毫秒数，获取Instant的实例 ---> Date(long mills)
        Instant instant1 = Instant.ofEpochMilli(1621305009977L);
        System.out.println(instant1);


    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
//        方式一：预定义的标准格式。如IOS_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCALTIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(localDateTime);//2021-05-18T10:38:14.022
        System.out.println(str);//2021-05-18T10:38:14.022

        //解析：字符串--->日期
        TemporalAccessor parse = formatter.parse("2021-05-18T10:38:14.022");
        System.out.println(parse);

//       方式二：
//       本地化相关的格式。如：ofLocalizedDateTime()
//       FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String str1 = formatter1.format(localDateTime);
        System.out.println(str1);

//      本地化相关的格式。如：ofLocalizedDate()
//      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str2 = formatter2.format(LocalDate.now());
        System.out.println(str2);//2021年5月18日 星期二

        //重点：方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str3 = formatter3.format(LocalDateTime.now());
        System.out.println(str3);//2021-05-18 11:33:30

        //解析
        TemporalAccessor accessor = formatter3.parse("2021-05-18 11:33:30");
        System.out.println(accessor);
    }

}
