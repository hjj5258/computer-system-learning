package com.yz.strategy.pattern;

public class MallardDuck extends Duck {
    /**
     * 通过构造器，定义MallardDuck具体的行为能力
     */
    public MallardDuck() {
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    public void display() {
        System.out.println("我是真实的鸭子，会飞会叫");
    }
}
