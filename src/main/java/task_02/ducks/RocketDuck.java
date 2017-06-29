package task_02.ducks;

import task_02.fly.FlyRocketPowered;
import task_02.quack.FakeQuack;

public class RocketDuck extends Duck {
    public RocketDuck() {
        setFlyBehavior(new FlyRocketPowered());
        setQuackBehavior(new FakeQuack());
    }

    @Override
    public void display() {
        System.out.print("I'm a real Rocket duck! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
