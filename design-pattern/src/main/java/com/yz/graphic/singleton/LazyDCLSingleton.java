package com.yz.graphic.singleton;

/**
 * @author hjj
 * @create 2022/10/18/22:27
 */
public class LazyDCLSingleton {
    private static volatile LazySingleton SINGLETON;

    public static LazySingleton getInstance() {
        if (SINGLETON == null) {
            synchronized (LazyDCLSingleton.class) {
                if (SINGLETON == null) {
                    SINGLETON = new LazySingleton();
                }
            }
        }
        return SINGLETON;
    }
}
