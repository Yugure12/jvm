package com.ethan.jvm.classload;

/**
 * 测试根类加载器加载数据
 *
 * @author Ethan Wang
 * @date 2020/1/1 16:55
 **/
public class MyTest18_1 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yugure/Desktop/");

        Class<?> clazz = loader1.loadClass("com.ethan.jvm.classload.MyTest1");

        System.out.println("class: "+ clazz.getClass());
        System.out.println("class loader : " + clazz.getClassLoader());


    }
}
