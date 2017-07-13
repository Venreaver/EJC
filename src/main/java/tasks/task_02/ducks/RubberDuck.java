package tasks.task_02.ducks;

import tasks.task_02.fly.FlyNoWay;
import tasks.task_02.quack.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.print("I'm a rubber duckie! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
