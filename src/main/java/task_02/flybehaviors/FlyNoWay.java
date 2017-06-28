package task_02.flybehaviors;

public class FlyNoWay implements FlyBehavior {
    @Override
    public int fly() {
        System.out.println("Я не умею летать!");
        return 0;
    }
}
