package task_02.ducks;

import task_02.flybehaviors.FlyBehavior;
import task_02.quackbehaviors.QuackBehavior;

public abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    abstract void display();

    public void swim() {
        System.out.println("Все утки могут плавать! Даже искуственные");
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
}
