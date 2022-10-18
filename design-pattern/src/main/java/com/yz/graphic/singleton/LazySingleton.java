package com.yz.graphic.singleton;

/**
 * @author hjj
 * @create 2022/10/18/22:27
 */
public class LazySingleton {
    private static LazySingleton SINGLETON;

    public static LazySingleton getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new LazySingleton();
        }
        return SINGLETON;
    }
}
