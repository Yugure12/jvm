package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2019/12/25 11:38
 **/
public class MyTest5_1 {

    public static void main(String[] args) {
        System.out.println(MyChild5_1.b);
    }
}

class MyGrandpa5_1 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandpa5_1 invoke");
        }
    };
}

class MyParent5_1 extends MyGrandpa5_1 {

    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 invoke");
        }
    };
}

class MyChild5_1 extends MyParent5_1 {
    public static int b = 5;
}

class c {

    {
        System.out.println("hello");
    }

    public c() {
        System.out.println("c");
    }
}
