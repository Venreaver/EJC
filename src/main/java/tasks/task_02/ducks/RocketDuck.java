package tasks.task_02.ducks;

import tasks.task_02.DuckConfig;
import tasks.task_02.fly.FlyRocketPowered;
import tasks.task_02.quack.FakeQuack;

public class RocketDuck extends Duck {
    public RocketDuck() {
        setFlyBehavior(new FlyRocketPowered());
        setQuackBehavior(new FakeQuack());
    }

    @Override
    public void display() {
        System.out.print(DuckConfig.ROCKET_DUCK);
        getFlyBehavior().displayFlyBehavior();
    }
}
