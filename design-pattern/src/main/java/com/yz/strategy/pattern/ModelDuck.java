package com.yz.strategy.pattern;

public class ModelDuck extends Duck{
    /**
     * 通过构造器，定义MallardDuck具体的行为能力
     */
    public ModelDuck() {
        setQuackBehavior(new MuteQuack());
        setFlyBehavior(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println("我是模型鸭子，不会飞不会叫");
    }
}
