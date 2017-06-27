package task_02;

public class RubberDuck extends Duck{
    public RubberDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Squeak());
    }

    @Override
    void display() {
        System.out.println("Я – резинова утка!");
    }
}
