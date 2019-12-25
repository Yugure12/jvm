package com.ethan.jvm.classload;

import java.util.Random;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成初始化
 * 只有在真正使用到父接口的时候(如引用接口中所定义的常量时)，才会被初始化
 *
 * @author Ethan Wang
 * @date 2019/12/25 11:01
 **/
public class MyTest5 {

    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
    public static final int a = new Random().nextInt(3);;
}

interface MyChild5 extends MyParent5 {
    public static final int b = 5;
}