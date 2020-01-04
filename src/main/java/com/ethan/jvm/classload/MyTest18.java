package com.ethan.jvm.classload;

/**
 * Java类加载器的各种加载路径
 * 从上往下依次为bootstrap类加载器、ext类加载器、app类加载器
 *
 * @author Ethan Wang
 * @date 2020/1/1 16:50
 **/
public class MyTest18 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
