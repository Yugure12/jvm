package com.ethan.jvm.classload;

import java.util.UUID;

/**
 * 当一个常量的值并非编译期间可以确定的，那么其值就不会放到调用类的常量池中
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
 *
 * @author Ethan Wang
 * @date 2019/12/25 11:01
 **/
public class MyTest3 {

    public static void main(String[] args) {
        System.out.println(MyParent3.str); //Student2, 6dbb23...
    }
}

class MyParent3 {
    static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 class block");
    }
}