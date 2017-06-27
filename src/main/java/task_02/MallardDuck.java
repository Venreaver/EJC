package task_02;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    void display() {
        System.out.println("Я – кряква!");
    }
}
