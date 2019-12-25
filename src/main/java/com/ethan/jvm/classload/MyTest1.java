package com.ethan.jvm.classload;

import javafx.scene.Parent;

/**
 * 对于静态字段来说，只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时，要求父类全部都已经初始化完毕
 * <p>
 * -XX:+TraceClassLoading，用于追踪类的加载信息并打印出来
 * <p>
 * jvm参数设置
 * -XX:+<option>，表示开启option选项
 * -XX:-<option>，表示关闭option选项
 * -XX:<option>=value，表示将option的值设置为value
 *
 * @author Ethan Wang
 * @date 2019/12/25 11:01
 **/
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyParent1.str1);
    }
}

class MyParent1 {
    static String str1 = "welcome Parent";

    static {
        System.out.println("MyParent1 class block");
    }
}

class MyChild1 extends MyParent1 {
    static String str2 = "welcome Child";

    static {
        System.out.println("MyChild1 class load");
    }
}