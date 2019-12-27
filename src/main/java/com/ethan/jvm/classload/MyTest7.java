package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2019/12/25 22:54
 **/
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.ethan.jvm.classload.C");
        System.out.println(clazz2.getClassLoader());
    }
}

class C {

}