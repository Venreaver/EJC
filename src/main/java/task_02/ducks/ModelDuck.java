package task_02.ducks;

import task_02.fly.FlyNoWay;
import task_02.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print("I'm a model duck! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
