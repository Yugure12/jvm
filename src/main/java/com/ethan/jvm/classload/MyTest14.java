package com.ethan.jvm.classload;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author Ethan Wang
 * @date 2019/12/27 20:48
 **/
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "com/ethan/jvm/classload/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resourceName);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
    }
}
