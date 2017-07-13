package tasks.task_02.fly;

import tasks.task_02.RaceConfig;

public class FlyWithWings implements FlyBehavior {
    @Override
    public int fly() {
        int speed = (int) (Math.random() * (RaceConfig.MAX_DUCK_SPEED - RaceConfig.MIN_DUCK_SPEED + 1))
                + RaceConfig.MIN_DUCK_SPEED;
        return Math.random() < 0.5 ? speed >> 1 : speed << 1;
    }

    @Override
    public void displayFlyBehavior() {
        System.out.print("I'm flying!!");
    }
}
