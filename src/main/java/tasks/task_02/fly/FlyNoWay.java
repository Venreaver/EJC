package tasks.task_02.fly;

import tasks.task_02.DuckConfig;

public class FlyNoWay implements FlyBehavior {
    @Override
    public int fly() {
        return 0;
    }

    @Override
    public void displayFlyBehavior() {
        System.out.print(DuckConfig.FLY_NO_WAY);
    }
}
