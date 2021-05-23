package com.allin.java;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口中声明的方法的测试
 *
 * 结论：
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 */

public class CollectionTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
//        Scanner scanner = new Scanner(System.in);
        coll.add(123);
        coll.add(456);
        Person p = new Person("Jerry",20);
        coll.add(p);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        //1.contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()。
//        int str = scanner.nextInt();
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        // Person类中没有重写equals()方式，调用的是Object中的==
        System.out.println(coll.contains(new Person("Jerry",20)));//false -> true
        System.out.println(coll.contains(p));//true

        //2.containsAll(Collection coll1):判断形参coll1中所有的元素是否存在当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test1(){
        //3.remove(Object obj)
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(123);
        System.out.println(coll);
        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll):从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //5.retainAll(Collection coll)：交集，获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3(){
        //ArrayList有序的元素位置要相同，set无序的可忽略排序问题
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry",20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        //6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        System.out.println(coll.equals(coll1));//false
    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //hash0Code():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合--->数组:toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }

        //拓展：数组--->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1);//将其看做一个元素了
        List arr2 = Arrays.asList(123, 456);
        System.out.println(arr2);
        List arr3 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr3);

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }

}


