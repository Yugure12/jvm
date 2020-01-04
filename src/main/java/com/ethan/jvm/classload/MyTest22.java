package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2020/1/2 18:01
 **/
public class MyTest22 {

    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());
    }
}
