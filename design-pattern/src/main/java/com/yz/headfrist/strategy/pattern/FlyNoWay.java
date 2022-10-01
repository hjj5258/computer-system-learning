package com.yz.headfrist.strategy.pattern;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}
