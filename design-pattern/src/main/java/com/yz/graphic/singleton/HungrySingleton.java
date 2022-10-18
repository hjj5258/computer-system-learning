package com.yz.graphic.singleton;

/**
 * @author hjj
 * @create 2022/10/18/22:27
 */
public class HungrySingleton {
    private static final HungrySingleton SINGLETON = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return SINGLETON;
    }
}
