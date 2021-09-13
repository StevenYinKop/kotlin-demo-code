package cc.stevenyin.design_pattern;

/**
 * 懒汉式(线程不安全, 不能使用!)
 */
public class _02_03_Singleton {
    private static _02_03_Singleton instance;

    private _02_03_Singleton() {

    }

    public static _02_03_Singleton getInstance() {
        if (instance == null) {
            instance = new _02_03_Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                _02_03_Singleton instance = _02_03_Singleton.getInstance();
                System.out.println("Thread name: " + Thread.currentThread() + ":" + instance);
            }).start();
        }
    }
}

