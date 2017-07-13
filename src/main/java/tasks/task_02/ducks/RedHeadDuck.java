package tasks.task_02.ducks;

import tasks.task_02.DuckConfig;
import tasks.task_02.fly.FlyByJump;
import tasks.task_02.quack.Quack;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyBehavior(new FlyByJump());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print(DuckConfig.REDHEAD_DUCK);
        getFlyBehavior().displayFlyBehavior();
    }
}
