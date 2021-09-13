package cc.stevenyin.design_pattern;

/**
 * 懒汉式 - 枚举形式
 */
public enum _02_06_Singleton {
    INSTANCE;

    public static _02_06_Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                _02_06_Singleton instance = _02_06_Singleton.getInstance();
                System.out.println("Thread name: " + Thread.currentThread() + ":" + instance);
            }).start();
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}

