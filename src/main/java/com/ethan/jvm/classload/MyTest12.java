package com.ethan.jvm.classload;

/**
 * 调用ClassLoader类的laodClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
 *
 * @author Ethan Wang
 * @date 2019/12/27 20:29
 **/
public class MyTest12 {
    public static void main(String[] args) throws Exception {
        System.out.println("------start------");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = classLoader.loadClass("com.ethan.jvm.classload.CL");
        System.out.println(aClass);
        System.out.println("-----");
        aClass = Class.forName("com.ethan.jvm.classload.CL");
        System.out.println(aClass);
    }
}

class CL {
    static {
        System.out.println("CL static block");
    }
}