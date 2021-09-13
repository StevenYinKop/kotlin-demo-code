package cc.stevenyin.design_pattern;

import java.util.Date;
import java.util.Random;

/**
 * 懒汉式(Double Check)
 */
public class _02_04_Singleton {
    private static volatile _02_04_Singleton instance;
    private String name;
    private Date date;

    private _02_04_Singleton() {
        try {
            Thread.sleep(new Random().nextInt(10000));
            date = new Date();
            name = "stevenyin";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static _02_04_Singleton getInstance() {
        if (instance == null) {
            synchronized (_02_04_Singleton.class) {
                if (instance == null) {
                    instance = new _02_04_Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                _02_04_Singleton instance = _02_04_Singleton.getInstance();
                System.out.println("Thread name: " + Thread.currentThread() + ":" + instance);
                if (instance.getDate() == null || instance.getName() == null) {
                    System.out.println("=========ERROR==========");
                }
                System.out.println(instance.getDate().toString());
                System.out.println(instance.name);
            }).start();
        }
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}

