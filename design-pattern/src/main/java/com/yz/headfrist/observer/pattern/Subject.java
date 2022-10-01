package com.yz.headfrist.observer.pattern;

/**
 * 主题接口
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知所有观察者
     */
    void notityObservers();
}
