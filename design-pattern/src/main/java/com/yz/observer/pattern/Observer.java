package com.yz.observer.pattern;

/**
 * 观察者接口
 */
public interface Observer {
    /**
     * 更新
     * @param temperature 温度值
     * @param humidity 湿度值
     * @param pressure 压力值
     */
    void update(float temperature, float humidity, float pressure);
}
