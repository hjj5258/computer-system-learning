package com.yz.headfrist.strategy.pattern;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("我回嘎嘎叫");
    }
}
