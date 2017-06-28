package task_02;

import task_02.ducks.Duck;
import task_02.ducks.ModelDuck;
import task_02.ducks.RocketDuck;
import task_02.flybehaviors.FlyRocketPowered;

public class DuckRace {
    public static final int MAX_DUCK_SPEED = 100;
    public static final int MIN_DUCK_SPEED = 10;

    public static void main(String[] args) {
        Duck duck = new RocketDuck();
        duck.performFly();
        duck.performQuack();
        Duck duck1 = new ModelDuck();
        duck1.performFly();
        duck1.performQuack();
        duck1.setFlyBehavior(new FlyRocketPowered());
        duck1.performFly();
        duck1.performQuack();
    }
}
