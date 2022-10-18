package com.yz.graphic.singleton;

/**
 * @author hjj
 * @create 2022/10/18/22:27
 */
public class LazyHolderSingleton {
    private static class SingletonHolder {
        private static final LazyHolderSingleton SINGLETON = new LazyHolderSingleton();
    }

    public static LazyHolderSingleton getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
