package task_02.ducks;

import task_02.fly.FlyByJump;
import task_02.quack.Quack;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyBehavior(new FlyByJump());
        setQuackBehavior(new Quack());
    }

    @Override
    public void display() {
        System.out.print("Я – красноголовый нырок! ");
        getFlyBehavior().displayFlyBehavior();
    }
}
