package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2019/12/27 20:38
 **/
public class MyTest13 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (null != classLoader) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }

}