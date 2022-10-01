package com.yz.headfrist.strategy.pattern;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("我会飞");
    }
}
