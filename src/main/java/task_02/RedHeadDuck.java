package task_02;

public class RedHeadDuck extends Duck {
    public RedHeadDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    @Override
    void display() {
        System.out.println("Я – красноголовый нырок!");
    }
}
