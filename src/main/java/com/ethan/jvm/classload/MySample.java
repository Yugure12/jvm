package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2020/1/1 14:44
 **/
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by : " + this.getClass().getClassLoader());
        new MyCat();
    }
}
