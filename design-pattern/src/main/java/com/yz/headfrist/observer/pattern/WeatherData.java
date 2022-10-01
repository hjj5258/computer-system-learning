package com.yz.headfrist.observer.pattern;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList Observers = new ArrayList();
    // 温度
    private float temperature;
    // 湿度
    private float humidity;
    // 压力
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        Observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = Observers.indexOf(o);
        if (i >= 0) {
            Observers.remove(o);
        }
    }

    @Override
    public void notityObservers() {
        for (int i = 0; i < Observers.size(); i++) {
            Observer observer = (Observer) Observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    /**
     * 测量改变事件方法
     */
    public void measurementsChanged() {
        notityObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 调用改变事件
        measurementsChanged();
    }
}
