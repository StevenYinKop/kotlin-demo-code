package cc.stevenyin.design_pattern;

/**
 * 懒汉式 - 静态内部类
 */
public class _02_05_Singleton {
    private _02_05_Singleton() {
        if (getInstance() != null) {
            throw new IllegalArgumentException("can not initialize singleton object!");
        }
    }

    public static _02_05_Singleton getInstance() {
        return Instance.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                _02_05_Singleton instance = _02_05_Singleton.getInstance();
                System.out.println("Thread name: " + Thread.currentThread() + ":" + instance);
            }).start();
        }
    }

    private static class Instance {
        private static final _02_05_Singleton INSTANCE = new _02_05_Singleton();
    }
}

