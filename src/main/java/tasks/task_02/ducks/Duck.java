package tasks.task_02.ducks;

import tasks.task_02.fly.FlyBehavior;
import tasks.task_02.quack.QuackBehavior;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public abstract void display();

    public void swim() {
        System.out.println("All ducks float, even decoys!");
    }

    public int performFly() {
        return flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }
}
