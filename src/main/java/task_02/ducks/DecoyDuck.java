package task_02.ducks;

import task_02.flybehaviors.FlyNoWay;
import task_02.quackbehaviors.MuteQuack;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    public void display() {
        System.out.println("Я – искуственная утка!");
    }
}
