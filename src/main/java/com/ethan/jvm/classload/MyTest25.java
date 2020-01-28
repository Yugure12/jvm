package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2020/1/8 18:00
 **/
public class MyTest25 implements Runnable {

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // 将当前线程的上下文类加载器设置为系统类加载器的时间在于Launcher初始化系统类加载器的时候。
        // 参考Launcher类的构造方法第56行
        ClassLoader classLoader = this.thread.getContextClassLoader();
//        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class : " + classLoader.getClass());
        System.out.println("Parent : " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
