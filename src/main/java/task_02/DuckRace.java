package task_02;

public class DuckRace {
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
