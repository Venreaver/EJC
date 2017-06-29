package task_02.fly;

import task_02.DuckRace;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public int fly() {
        int speed = (int) (Math.random() * (DuckRace.MAX_DUCK_SPEED * 2 - DuckRace.MIN_DUCK_SPEED + 1))
                + DuckRace.MIN_DUCK_SPEED;
        return Math.random() < 0.5 ? speed >> 1 : speed << 1;
    }

    @Override
    public void displayFlyBehavior() {
        System.out.print("Я лечу на ракете!");
    }
}
