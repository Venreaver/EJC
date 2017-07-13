package tasks.task_02.ducks;

import tasks.task_02.DuckConfig;
import tasks.task_02.fly.FlyNoWay;
import tasks.task_02.quack.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.print(DuckConfig.DECOY_DUCK);
        getFlyBehavior().displayFlyBehavior();
    }
}
