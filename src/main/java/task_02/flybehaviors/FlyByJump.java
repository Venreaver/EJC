package task_02.flybehaviors;

import task_02.DuckRace;

public class FlyByJump implements FlyBehavior {
    @Override
    public int fly() {
        System.out.println("Лечу в прыжке!");
        int speed = (int) (Math.random() * (DuckRace.MAX_DUCK_SPEED / 2 - DuckRace.MIN_DUCK_SPEED + 1))
                + DuckRace.MIN_DUCK_SPEED;
        return Math.random() < 0.5 ? speed >> 1 : speed << 1;
    }
}
