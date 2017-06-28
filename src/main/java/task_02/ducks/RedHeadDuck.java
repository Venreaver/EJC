package task_02.ducks;

import task_02.flybehaviors.FlyByJump;
import task_02.flybehaviors.FlyWithWings;
import task_02.quackbehaviors.Quack;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyBehavior(new FlyByJump());
        setQuackBehavior(new Quack());
    }

    @Override
    void display() {
        System.out.println("Я – красноголовый нырок!");
    }
}
