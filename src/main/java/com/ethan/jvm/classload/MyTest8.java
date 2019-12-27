package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2019/12/25 23:04
 **/
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {
    public static final int x = 3;

    static {
        System.out.println("FinalTest static block");
    }
}
