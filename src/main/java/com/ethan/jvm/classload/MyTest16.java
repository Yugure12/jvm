package com.ethan.jvm.classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Ethan Wang
 * @date 2019/12/28 17:30
 **/
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        // 将SystemClassLoader系统类加载器当作该类的父加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader perent) {
        // 显示指定该类加载器的父类加载器。
        super(perent);
    }

    public MyTest16(ClassLoader perent, String classLoaderName) {
        // 显示指定该类加载器的父类加载器。
        super(perent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("find class invoked : " + className);
        System.out.println("class loader name：" + this.classLoaderName);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        FileInputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        name = name.replace(".", "/");
        try {
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yugure/Desktop/");
        Class<?> clazz = loader1.loadClass("com.ethan.jvm.classload.MyTest1");
        System.out.println("class : " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
//
//        System.out.println();
//
//        MyTest16 loader2 = new MyTest16(loader1, "loader2");
//        loader2.setPath("/Users/yugure/Desktop/");
//        Class<?> clazz2 = loader2.loadClass("com.ethan.jvm.classload.MyTest1");
//        System.out.println("class2 : " + clazz2.hashCode());
//        Object object2 = clazz.newInstance();
//        System.out.println(object2);
//
//        System.out.println();
//
//        MyTest16 loader3 = new MyTest16("loader3");
//        loader3.setPath("/Users/yugure/Desktop/");
//        Class<?> clazz3 = loader3.loadClass("com.ethan.jvm.classload.MyTest1");
//        System.out.println("class3 : " + clazz3.hashCode());
//        Object object3 = clazz.newInstance();
//        System.out.println(object3);




        // 测试类的卸载
        loader1 = null;
        clazz = null;
        object = null;
        System.gc();

        // 通过JVisualVM工具来观察卸载
        Thread.sleep(20000);

        loader1 = new MyTest16("loader1");
        loader1.setPath("/Users/yugure/Desktop/");
        clazz = loader1.loadClass("com.ethan.jvm.classload.MyTest1");
        System.out.println("class : " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);
    }
}
