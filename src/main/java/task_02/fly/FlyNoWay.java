package task_02.fly;

public class FlyNoWay implements FlyBehavior {
    @Override
    public int fly() {
        return 0;
    }

    @Override
    public void displayFlyBehavior() {
        System.out.print("Я не умею летать!");
    }
}