package task_02;

public class DecoyDuck extends Duck {
    public DecoyDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }

    @Override
    void display() {
        System.out.println("Я – искуственная утка!");
    }
}
