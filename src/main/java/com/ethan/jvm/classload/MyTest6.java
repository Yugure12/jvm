package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2019/12/25 11:17
 **/
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1：" + Singleton.counter1);
        System.out.println("counter2：" + Singleton.counter2);
    }
}

class Singleton {

    public static int counter1 = 1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++; // 准备阶段的重要意义。准备阶段为变量设置的是默认值。
        System.out.println(counter1);
        System.out.println(counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}