package com.ethan.jvm.classload;

/**
 * 当前类加载器：(Current Classloader)
 * 每个类都会使用自己的类加载器(即加载自身的类加载器)去加载其他类（指的是所依赖的类）。
 * 如果ClassX引用了ClassY，那么ClassX的类加载器就会去加载ClassY(前提是ClassY尚未加载)
 *
 * 线程上下文类加载器(Content ClassLoader)
 * 线程上下文类加载器是从JDK1.2开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader cl)
 * 分别用来获取和设置上下文类加载器。
 *
 * 如果没有通过与setContextClassLoader(ClassLoader cl)进行设置的话，线程将继承其父线程的上下文类加载器。
 * Java应用运行时的初始线程的上下文类加载器是系统类加载器，在线程中运行的代码可以通过该类加载器来加载类与资源。
 *
 *
 * SPI (Service Provider Interface)
 * 父CLassLoader可以使用当前线程Thread.currentThread().getContextLoader()所指定的classloader加载的类。
 * 这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的ClassLoader加载的类的情况，即改变了双亲委托模型。
 * @author Ethan Wang
 * @date 2020/1/4 18:04
 **/
public class MyTest24 {

    public static void main(String[] args) {

        // 线程上下文的类加载器：APPClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        // 线程类的类加载器：BootstrapClassLoader
        System.out.println(Thread.class.getClassLoader());
    }

}
