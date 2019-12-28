package com.ethan.jvm.classload;

/**
 * @author Ethan Wang
 * @date 2019/12/27 21:23
 **/
public class MyTest15 {
    /**
     * A class loader is an object that is responsible for loading classes. The
     * class <tt>ClassLoader</tt> is an abstract class.  Given the <a
     * href="#name">binary name</a> of a class, a class loader should attempt to
     * locate or generate data that constitutes a definition for the class.  A
     * typical strategy is to transform the name into a file name and then read a
     * "class file" of that name from a file system.
     * 类加载器就是一个负责加载类的对象。类加载器是一个抽象类。
     * 给定一个类的二进制名字，类加载器会尝试定位或生成构成类定义的数据。
     * 一个典型的策略是将给定的类二进制名字转换成文件名，然后从系统中读取文件名所对应的字节码文件。
     *
     * <p> Every {@link Class <tt>Class</tt>} object contains a {@link
     * Class#getClassLoader() reference} to the <tt>ClassLoader</tt> that defined
     * it.
     *
     * <p> <tt>Class</tt> objects for array classes are not created by class
     * loaders, but are created automatically as required by the Java runtime.
     * The class loader for an array class, as returned by {@link
     * Class#getClassLoader()} is the same as the class loader for its element
     * type; if the element type is a primitive type, then the array class has no
     * class loader.
     * 数组类的class不是由类加载器生成，而是在JVM运行期间需要被创建的时候动态生成的。
     * 数组类型的类加载器，由Class.getClassLoader()返回，和数组元素的类型是相同的。
     * 如果数组类型是原生类型，那么数组类就没有类加载器。
     *
     * <p> Applications implement subclasses of <tt>ClassLoader</tt> in order to
     * extend the manner in which the Java virtual machine dynamically loads
     * classes.
     * 应用实现了ClassLoader的子类，是为了扩展JVM虚拟机动态加载类的方式。
     *
     * <p> Class loaders may typically be used by security managers to indicate
     * security domains.
     * 通常，类加载器会表明安全管理器的安全域。
     *
     * <p> The <tt>ClassLoader</tt> class uses a delegation model to search for
     * classes and resources.  Each instance of <tt>ClassLoader</tt> has an
     * associated parent class loader.  When requested to find a class or
     * resource, a <tt>ClassLoader</tt> instance will delegate the search for the
     * class or resource to its parent class loader before attempting to find the
     * class or resource itself.  The virtual machine's built-in class loader,
     * called the "bootstrap class loader", does not itself have a parent but may
     * serve as the parent of a <tt>ClassLoader</tt> instance.
     * 类加载器的class类采用委托模型(双亲委派)去寻找类和资源。ClassLoader的每个实例都会有一个与之关联的父ClassLoader，
     * 当我们要求Classloader去寻找类或资源的时候，在它自己尝试加载这个类或资源之前，classLoader实例会将对类或资源的寻找委托给它的父类加载器。
     * 虚拟机内建的类加载器我们称为启动类加载器或根类加载器，它本身没有双亲，但是它可以作为类加载器的双亲。
     *
     * <p> Class loaders that support concurrent loading of classes are known as
     * <em>parallel capable</em> class loaders and are required to register
     * themselves at their class initialization time by invoking the
     * {@link
     * #registerAsParallelCapable <tt>ClassLoader.registerAsParallelCapable</tt>}
     * method. Note that the <tt>ClassLoader</tt> class is registered as parallel
     * capable by default. However, its subclasses still need to register themselves
     * if they are parallel capable. <br>
     * 支持并发的类加载器我们称为并行类加载器。
     * 需要它在类初始化期间通过ClassLoader.registerAsParallelCapable将自己注册上，标识这个类加载器是可以并发加载。
     * ClassLoader默认被标记为可以并行的。然而，它的子类需要并行加载，那么依然是需要将自己注册上。
     *
     * In environments in which the delegation model is not strictly
     * hierarchical, class loaders need to be parallel capable, otherwise class
     * loading can lead to deadlocks because the loader lock is held for the
     * duration of the class loading process (see {@link #loadClass
     * <tt>loadClass</tt>} methods).
     * 在委托模型并不是严格的模型下，类加载器需要做到并行。否则类加载器会造成死锁。因为加载器的锁是在类加载过程一直被持有。
     *
     * <p> Normally, the Java virtual machine loads classes from the local file
     * system in a platform-dependent manner.  For example, on UNIX systems, the
     * virtual machine loads classes from the directory defined by the
     * <tt>CLASSPATH</tt> environment variable.
     * 通常情况下，JVM虚拟机会以平台相关的方式从本地的文件系统(classpath定义的目录中)中加载类。
     *
     * <p> However, some classes may not originate from a file; they may originate
     * from other sources, such as the network, or they could be constructed by an
     * application.  The method {@link #defineClass(String, byte[], int, int)
     * <tt>defineClass</tt>} converts an array of bytes into an instance of class
     * <tt>Class</tt>. Instances of this newly defined class can be created using
     * {@link Class#newInstance <tt>Class.newInstance</tt>}.
     * 然而，一些类并不是来自文件，他们可能有其他的来源。比如网络，或者他们是由应用本身构建的(动态代理)。
     * 定义类definedClass会将字节数组转换成class的一个实例对象，新定义的这个实例可以通过Class.newInstance来创建。
     *
     * <p> The methods and constructors of objects created by a class loader may
     * reference other classes.  To determine the class(es) referred to, the Java
     * virtual machine invokes the {@link #loadClass <tt>loadClass</tt>} method of
     * the class loader that originally created the class.
     * 由类加载器创建的对象，其方法与构造方法还可能引用其他的类。
     * 为了确定被引用的类都有什么，JVM虚拟机会去通过方法的类加载器的loadClass方法去最初创建类。
     *
     * <p> For example, an application could create a network class loader to
     * download class files from a server.  Sample code might look like:
     *
     * <blockquote><pre>
     *   ClassLoader loader&nbsp;= new NetworkClassLoader(host,&nbsp;port);
     *   Object main&nbsp;= loader.loadClass("Main", true).newInstance();
     *       &nbsp;.&nbsp;.&nbsp;.
     * </pre></blockquote>
     *
     * <p> The network class loader subclass must define the methods {@link
     * #findClass <tt>findClass</tt>} and <tt>loadClassData</tt> to load a class
     * from the network.  Once it has downloaded the bytes that make up the class,
     * it should use the method {@link #defineClass <tt>defineClass</tt>} to
     * create a class instance.  A sample implementation is:
     * 网络类加载器的子类必须要定义findClass和loadClassData去加载类。
     * 一旦它下载好类的字节码文件，它会通过defineClass去创建类的实例。
     *
     * <blockquote><pre>
     *     class NetworkClassLoader extends ClassLoader {
     *         String host;
     *         int port;
     *
     *         public Class findClass(String name) {
     *             byte[] b = loadClassData(name);
     *             return defineClass(name, b, 0, b.length);
     *         }
     *
     *         private byte[] loadClassData(String name) {
     *             // load the class data from the connection
     *             &nbsp;.&nbsp;.&nbsp;.
     *         }
     *     }
     * </pre></blockquote>
     *
     * <h3> <a name="name">Binary names</a> </h3>
     *
     * <p> Any class name provided as a {@link String} parameter to methods in
     * <tt>ClassLoader</tt> must be a binary name as defined by
     * <cite>The Java&trade; Language Specification</cite>.
     *
     * <p> Examples of valid class names include:
     * <blockquote><pre>
     *   "java.lang.String"
     *   "javax.swing.JSpinner$DefaultEditor"
     *   "java.security.KeyStore$Builder$FileBuilder$1"
     *   "java.net.URLClassLoader$3$1"
     * </pre></blockquote>
     *
     * @see #resolveClass(Class)
     * @since 1.0
     */
    public static void main(String[] args) {

        String[] strings = new String[3];
        System.out.println(strings.getClass());
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("------");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("----");
        int[] ints = new int[12];
        System.out.println(ints.getClass().getClassLoader());
    }
}
