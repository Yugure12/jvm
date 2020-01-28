package com.ethan.jvm.classload;

import java.sql.DriverManager;

/**
 * @author Ethan Wang
 * @date 2020/1/8 18:07
 **/
public class MyTest27 {

    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql//localhost:3306/mybdtest", "username", "password");
    }
}
