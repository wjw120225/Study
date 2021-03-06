package com.allin.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 */
public class ForTest {

    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //for(集合(数组)元素的类型 局部变量： 集合对象(数组))
        //内部仍然调用了迭代器。
        for(Object obj : coll){
            System.out.println(obj);
        }

        int[] arr = new int[]{1,2,3,4,5,6};

        for(int i : arr){
            System.out.println(i);
        }
    }
    //练习题
    @Test
    public void test1(){
        String[] arr = new String[]{"MM","MM","MM"};
        //方式一：普通for循环赋值
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }//GG GG GG
        //方式二：增强for循环（foreach循环）
        for (String s : arr){
            s = "GG";
//            System.out.println(s);//GG GG GG 相当于将arr[i]中各个元素赋值给了s
        }//MM MM MM

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
