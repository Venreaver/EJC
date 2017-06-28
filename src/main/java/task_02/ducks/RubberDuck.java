package task_02.ducks;

import task_02.flybehaviors.FlyNoWay;
import task_02.quackbehaviors.Squeak;

public class RubberDuck extends Duck {
    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    public void display() {
        System.out.print("Я – резинова утка! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
