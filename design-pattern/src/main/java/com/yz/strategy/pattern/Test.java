package com.yz.strategy.pattern;

public class Test {
    public static void main(String[] args) {
        Duck duck1 = new MallardDuck();
        duck1.performQuack();
        duck1.performFly();
        duck1.display();

        System.out.println("==============");

        Duck duck2 = new ModelDuck();
        duck2.performQuack();
        duck2.performFly();
        duck2.display();
        duck2.setFlyBehavior(new FlyRocketPowered());
        duck2.performFly();

    }
}
