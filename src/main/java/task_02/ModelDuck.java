package task_02;

public class ModelDuck extends Duck{
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }

    @Override
    void display() {
        System.out.println("Я – утка-приманка!");
    }
}
