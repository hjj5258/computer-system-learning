package com.yz.observer.pattern;

public class Test {
    public static void main(String[] args) {
        // WeatherData impl Subject
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);
    }
}
