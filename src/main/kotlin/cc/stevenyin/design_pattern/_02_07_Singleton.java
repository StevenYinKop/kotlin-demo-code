package cc.stevenyin.design_pattern;

/**
 * 懒汉式 - 枚举形式(懒加载)
 */
public class _02_07_Singleton {
    public static _02_07_Singleton getInstance() {
        return Instance.INSTANCE.singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                _02_07_Singleton instance = _02_07_Singleton.getInstance();
                System.out.println("Thread name: " + Thread.currentThread() + ":" + instance);
            }).start();
        }
    }

    private enum Instance {
        INSTANCE;
        private _02_07_Singleton singleton;

        Instance() {
            singleton = new _02_07_Singleton();
        }

        @Override
        public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
    }
}

