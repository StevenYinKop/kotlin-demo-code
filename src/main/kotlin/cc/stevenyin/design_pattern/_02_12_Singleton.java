package cc.stevenyin.design_pattern;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射攻击
 */
public class _02_12_Singleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 获取单例对象
        _02_06_Singleton singleton1 = _02_06_Singleton.getInstance();
        _02_06_Singleton singleton2 = _02_06_Singleton.getInstance();

        Class objectClass = _02_06_Singleton.class;
        // 打开private构造函数的权限
        // 获取单例类的构造函数
        Constructor constructor = objectClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        _02_06_Singleton singleton = (_02_06_Singleton) constructor.newInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton);
    }
}

