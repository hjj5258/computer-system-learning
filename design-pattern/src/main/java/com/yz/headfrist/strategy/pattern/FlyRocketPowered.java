package com.yz.headfrist.strategy.pattern;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("装上火箭，我能飞了");
    }
}
