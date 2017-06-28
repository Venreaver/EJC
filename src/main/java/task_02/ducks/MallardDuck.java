package task_02.ducks;

import task_02.flybehaviors.FlyWithWings;
import task_02.quackbehaviors.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print("Я – кряква! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
