package cc.stevenyin.design_pattern;

import java.io.*;

/**
 * 序列化破坏
 */
public class _02_11_Singleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 获取单例对象
        _02_06_Singleton singleton1 = _02_06_Singleton.getInstance();
        _02_06_Singleton singleton2 = _02_06_Singleton.getInstance();
        _02_06_Singleton singleton3 = _02_06_Singleton.getInstance();
        _02_11_Singleton operation = new _02_11_Singleton();
        operation.serializeObject(singleton1);
        _02_06_Singleton newSingleton = (_02_06_Singleton) operation.deserializeObject();
        _02_06_Singleton singleton4 = _02_06_Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton3);
        System.out.println(singleton4);
        System.out.println(newSingleton);
    }

    private void serializeObject(Serializable s) throws IOException {
        // 新建一个对象输出流, 并且指定输出的位置
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_serializable"));
        // 将单例对象实例化
        oos.writeObject(s);
    }

    private Serializable deserializeObject() throws IOException, ClassNotFoundException {
        // 读取该单例对象
        File file = new File("singleton_serializable");
        // 获取对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        // 反序列化单例对象
        return (Serializable) ois.readObject();

    }
}

