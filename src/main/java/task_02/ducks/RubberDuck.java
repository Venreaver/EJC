package task_02.ducks;

import task_02.fly.FlyNoWay;
import task_02.quack.Squeak;

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
