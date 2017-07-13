package tasks.task_02.quack;

import tasks.task_02.DuckConfig;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println(DuckConfig.QUACK);
    }
}
