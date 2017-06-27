package task_02;

public class RocketDuck extends Duck {
    public RocketDuck() {
        setFlyBehavior(new FlyRocketPowered());
        setQuackBehavior(new FakeQuack());
    }

    @Override
    void display() {
        System.out.println("Я - утка-ракета!");
    }
}
