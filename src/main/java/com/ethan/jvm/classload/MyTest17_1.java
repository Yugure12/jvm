package com.ethan.jvm.classload;

/**
 * 关于命名空间的可能重要说明
 *
 * 1、子加载器所加载的类能够访问父加载器所加载的类；
 * 2、父加载器所加载的类无法访问子加载器所加载的类；
 *
 * @author Ethan Wang
 * @date 2020/1/1 14:59
 **/
public class MyTest17_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yugure/Desktop/");

        Class<?> clazz = loader1.loadClass("com.ethan.jvm.classload.MySample");
        System.out.println("class:" + clazz.hashCode());

        // 如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
        // 因此不会实例化Mycat对象，即没有对MyCat进行主动使用，这里就不会加载Mycat Class
        Object object = clazz.newInstance();
    }
}
