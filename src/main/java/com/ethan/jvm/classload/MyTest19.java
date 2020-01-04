package com.ethan.jvm.classload;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * 测试扩展类加载器加载类
 *
 * @author Ethan Wang
 * @date 2020/1/1 17:12
 **/
public class MyTest19 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
