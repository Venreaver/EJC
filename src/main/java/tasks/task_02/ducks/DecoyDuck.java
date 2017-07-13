package tasks.task_02.ducks;

import tasks.task_02.fly.FlyNoWay;
import tasks.task_02.quack.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.print("I'm a duck Decoy! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
