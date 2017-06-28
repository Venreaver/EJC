package task_02.ducks;

import task_02.flybehaviors.FlyNoWay;
import task_02.quackbehaviors.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print("Я – утка-приманка! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
