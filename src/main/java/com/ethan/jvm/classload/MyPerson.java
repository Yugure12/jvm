package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2020/1/1 17:26
 **/
public class MyPerson {

    private MyPerson myPerson;

    public void setMyPerson(Object myPerson) {
        this.myPerson = (MyPerson) myPerson;
    }
}
