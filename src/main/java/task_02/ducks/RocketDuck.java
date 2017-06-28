package task_02.ducks;

import task_02.quackbehaviors.FakeQuack;
import task_02.flybehaviors.FlyRocketPowered;

public class RocketDuck extends Duck {
    public RocketDuck() {
        setFlyBehavior(new FlyRocketPowered());
        setQuackBehavior(new FakeQuack());
    }

    @Override
    void display() {
        System.out.println("Я - утка-ракета!");
    }
}
