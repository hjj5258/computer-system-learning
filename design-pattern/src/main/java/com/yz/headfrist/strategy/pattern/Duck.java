package com.yz.headfrist.strategy.pattern;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    /**
     * 此时调用抽象Quack能力，并委托给当前Duck，对外暴露
     */
    public void performQuack() {
        quackBehavior.quack();
    }

    /**
     * 此时调用抽象Quack能力，并委托给当前Duck，对外暴露
     */
    public void performFly() {
        flyBehavior.fly();
    }

    public void display() {
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

}
