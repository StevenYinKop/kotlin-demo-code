package cc.stevenyin.design_pattern;

/**
 * 饿汉式
 */
public class _02_02_Singleton {
    private static _02_02_Singleton instance = new _02_02_Singleton();

    private _02_02_Singleton() {

    }

    public static _02_02_Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                _02_02_Singleton instance = _02_02_Singleton.getInstance();
                System.out.println("Thread name: " + Thread.currentThread() + ":" + instance);
            }).start();
        }
    }
}

