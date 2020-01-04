package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2020/1/1 14:42
 **/
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by ：" + this.getClass().getClassLoader());
    }
}
