package tasks.task_02.ducks;

import tasks.task_02.fly.FlyNoWay;
import tasks.task_02.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print("I'm a model duck! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
